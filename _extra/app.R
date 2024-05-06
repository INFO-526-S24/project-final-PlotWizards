if (!require("pacman")) 
  install.packages("pacman")

# use this line for installing/loading
pacman::p_load(devtools) 

pacman::p_load(tidyverse,
               dsbox,
               gtable,
               ggpubr,
               ggmap,
               ggrepel,
               patchwork,
               units,
               lubridate,
               pander,
               gridExtra,
               ggrepel,
               plotly,
               glue,
               here,
               flexdashboard,
               highcharter,
               htmltools,
               knitr,
               lubridate,
               shiny,
               knitr,
               httr,
               jsonlite,
               sf,
               rnaturalearth,
               rnaturalearthdata)


# Read the complete dataset outside the reactive context to improve performance
odi_data <- read.csv("../data/filtered_data_5years.csv")

y = read.csv("https://docs.google.com/spreadsheets/d/e/2PACX-1vSd_HEZE5_vyvgzAcOIXqaCvgefTD-B8suE03j46W_pryfgcHBNAne_mVSKNHTIAbB03BkjxbvXFHlr/pub?gid=0&single=true&output=csv")

url = toString(y[1, "local"])

apiUrl = paste0(url, "/analyzingtrends/getentirelivedata")

ui <- fluidPage(
  titlePanel(title = "Cricket Metrics"),
  sidebarLayout(
    sidebarPanel(
      selectInput(
        inputId = "bowling_team",
        label = "Choose a Country:",
        choices = c(
          "India",
          "Australia",
          "England",
          "South Africa",
          "Pakistan",
          "West Indies",
          "Ireland",
          "Scotland",
          "Nepal",
          "Canada",
          "United States",
          "Oman",
          "United Arab Emirates",
          "Zimbabwe",
          "Afghanistan",
          "Netherlands"
        ),
        selected = "India"
      ),
      selectInput(inputId = "season",
                  label = "Select Season:",
                  choices = unique(odi_data$season),
                  selected = unique(odi_data$season)[1])
    ),
    mainPanel(
      tabsetPanel(
        type = "tabs",
        tabPanel("Tab A", 
                 plotOutput(outputId = "scorePlot"),
                 highchartOutput(outputId = "batsmanPlot")),
        tabPanel("Tab B", 
                 uiOutput("subCategorySelection"),
                 plotOutput(outputId = "bowlingplot"),
                 plotlyOutput(outputId = "dougnut")),
        tabPanel("Tab C",
                 plotlyOutput(outputId = "choropleth_map"),
                 plotlyOutput(outputId = "partnership")),
        tabPanel("Live",
                 plotOutput("livePlot", height = 800))
      )
    )
  )
)

# Define server function -------------------------------------------------------

server <- function(input, output, session) {
  
  # Reactive expression to filter the data based on selected country
  filteredData <- reactive({
    odi_data %>%
      filter(bowling_team == input$bowling_team) %>%
      filter(season == input$season) |>
      group_by(innings, ball) %>%
      summarise(Runs_Scored = mean(runs_off_bat), .groups = "drop") %>%
      group_by(innings, over = floor(ball)) %>%
      summarise(Total_Runs = sum(Runs_Scored), .groups = "drop")
  })
  
  
  # Render the plot based on the filtered data
  output$scorePlot <- renderPlot({
    
    ggplot(filteredData(), aes(x = over, y = Total_Runs, color = factor(innings))) +
      geom_line() +
      labs(x = "Overs", 
           y = "Runs given to opponent / Over", 
           title = "Scoring Rate Evolution",
           color = "Innings") +
      theme_minimal() 
  })
  
  # Reactive expression to filter data based on selected season and calculate the top batsmen
  topBatsmenData <- reactive({
    odi_data %>%
      filter(season == input$season) %>% 
      filter(batting_team == input$bowling_team) |>
      group_by(striker) %>%
      summarise(Total_Runs = sum(runs_off_bat), .groups = "drop") %>%
      top_n(10, Total_Runs) %>%
      arrange(desc(Total_Runs))
  })
  
  # Render the interactive plot output for top batsmen
  output$batsmanPlot <- renderHighchart({
    top_batsmen <- topBatsmenData()
    
    highchart() %>%
      hc_title(text = "Top Batsmen by Total Runs Scored") %>%
      hc_xAxis(categories = top_batsmen$striker) %>%
      hc_yAxis(title = list(text = "Total Runs Scored")) %>%
      hc_add_series(name = "Total Runs", data = top_batsmen$Total_Runs, type = "column")
  })
  
  output$subCategorySelection <- renderUI({
    category <- input$season
    
    t = odi_data |> filter(season == input$season)
    idList = unique(t$match_id)
    # Define sub-categories based on the selected category
    subCategories <- idList
    
    # Create a select input for sub-categories
    selectInput("subCategory", "Select Match:", choices = subCategories)
  })
  
  filteredDataB <- reactive({
    odi_data %>%
      filter(match_id == input$subCategory) |>
      mutate(over = floor(ball)) |>
      group_by(batting_team) |>
      mutate(runs = cumsum(runs_off_bat + extras))
  })
  
  output$bowlingplot <- renderPlot({
    ggplot(data = filteredDataB(), aes(x = ball, y = runs, color = batting_team)) +
      geom_line() +
      labs(
        x = "Overs",
        y = "Runs",
        title = "Scoring Rate Evolution",
        color = "Team"
      ) +
      theme_minimal()
  })
  
  # Filter data for the selected season
  filtered_season_data <- reactive({
    odi_data %>%
      filter(season == input$season) %>%
      group_by(team1) %>%
      summarise(total_runs = sum(as.numeric(runs_off_bat)), .groups = 'drop')
  })
  
  # Create pie chart or half eye plot using plotly
  output$dougnut <- renderPlotly({
    # Access filtered data
    data <- filtered_season_data()
    
    print(data)
    
    # Create half eye plot using plotly
    half_eye_plot <- plot_ly(data, labels = ~team1, values = ~total_runs, type = "pie",
                             marker = list(colors = rainbow(nrow(data))),
                             hole = 0.4) %>%
      layout(title = paste("Total Runs Scored by Countries in", input$season),
             showlegend = FALSE)
    
    # Return the half eye plot
    half_eye_plot
  })
  
  
  # Reactive function to filter data based on selected season
  partnership_data <- reactive({
    selected_data <- odi_data %>%
      filter(season == input$season) %>%
      group_by(striker, non_striker) %>%
      summarise(partnership_runs = sum(as.numeric(runs_off_bat)), .groups = 'drop') %>%
      arrange(desc(partnership_runs)) %>%
      top_n(10)
    return(selected_data)
  })
  
  # Render the plot as an interactive Plotly plot
  output$partnership <- renderPlotly({
    
    # Filter data based on selected season
    data <- partnership_data()
    
    # Create Plotly plot for top batting partnerships
    plot_ly(data, x = ~reorder(paste(striker, non_striker, sep = " & "), -partnership_runs), y = ~partnership_runs, type = "bar", color = ~striker) %>%
      layout(title = paste("Top 10 Batting Partnerships in", input$season),
             xaxis = list(title = "Batsman Pair"),
             yaxis = list(title = "Partnership Runs"),
             barmode = "stack")
  })
  
  
  # Filter data for the selected season
  filtered_season_data_map <- reactive({
    odi_data %>%
      filter(season == input$season) %>%
      group_by(team1) %>%
      summarise(`Total Runs` = sum(as.numeric(runs_off_bat)), .groups = 'drop')
  })
  
  # Create choropleth map using plotly
  output$choropleth_map <- renderPlotly({
    # Access filtered data
    data <- filtered_season_data_map()
    
    # Load world map data
    world_map <- map_data("world")
    
    # Merge data with world map
    merged_data <- merge(world_map, data, by.x = "region", by.y = "team1", all.x = TRUE)
    
    # Create choropleth map with a different color palette
    plot_ly(merged_data, z = ~`Total Runs`, locations = ~region, locationmode = "country names",
            type = "choropleth", colors = "YlGnBu",  # Changed color palette to YlGnBu
            marker = list(line = list(color = "rgb(255,255,255)", width = 2))) %>%
      layout(title = paste("Total Runs Scored by Countries in", input$selected_season),
             geo = list(
               scope = "world",
               projection = list(type = "natural earth"),
               showframe = FALSE,  # Remove frame around map
               showcoastlines = TRUE,  # Show coastlines
               showocean = TRUE,  # Show ocean
               showland = TRUE,  # Show land
               showcountries = TRUE,  # Show country borders
               countrycolor = "rgb(255, 255, 255)",  # Country border color
               countrywidth = 0.5,  # Country border width
               dragmode = "select"  # Enable selection with cursor
             ),
             dragmode = "pan",  # Enable panning
             margin = list(l = 0, r = 0, t = 30, b = 0),  # Adjust margins for better display
             updatemenus = list(
               list(
                 buttons = list(
                   list(args = list(zoom = 1), label = "+", method = "relayout"),
                   list(args = list(zoom = -1), label = "-", method = "relayout")
                 ),
                 direction = "left",
                 showactive = FALSE,
                 type = "buttons",
                 x = 0.05,
                 xanchor = "right",
                 y = 0.05,
                 yanchor = "bottom"
               )
             )
      )
  })

  autoInvalidate <- reactiveTimer(500)
  
  # Function to generate random data
  generateData <- function() {
    
    
    # Make GET request to the API
    response = GET(apiUrl) 
    
    
    # Check if the request was successful
    if (http_status(response)$category == "Success") {
      
      # Parse JSON content
      jsonContent = content(response, "text", encoding = "UTF-8")
      
      # Convert JSON to list
      dataList = fromJSON(jsonContent, simplifyVector = FALSE)
      
      # Flatten the nested lists
      flatten_list <- lapply(dataList, unlist)
      
      # Convert to dataframe
      liveData <- as.data.frame(do.call(rbind, flatten_list))
      return(liveData)
      
    } else {
      # Print error message if request failed
      print("Failed to retrieve data from the API.")
      return(NULL)
    }
  }
  
  # Reactive expression to update data at fixed intervals
  liveData <- reactive({
    autoInvalidate()
    generateData()
  })
  
  # Render the plot
  output$livePlot <- renderPlot({
    
    data <- liveData()
    liveData <- data %>%
      mutate(over = floor(as.double(ball))) |>
      group_by(battingTeam) |>
      mutate(runs = cumsum(as.integer(runsOffBat) + as.integer(extras)))
    
    ggplot(liveData, aes(x = as.double(ball), y = runs, color = battingTeam)) +
      geom_point() +
      geom_line() +
      xlim(0, 50) +
      ylim(0, 500) +
      labs(
        x = "Overs",
        y = "Runs",
        title = "Scoring Rate Evolution",
        color = "Team"
      ) +
      theme_minimal() +
      theme(plot.margin = margin(5, 5, 2, 2))
  })
  

}

# Create the Shiny app object --------------------------------------------------

shinyApp(ui = ui, server = server)
