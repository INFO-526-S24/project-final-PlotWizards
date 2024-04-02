# Data

We sourced the dataset for this project from [kaggle](https://www.kaggle.com/datasets/utkarshtomar736/odi-mens-cricket-match-data-2002-2023).

-   **ODI_Match_Data.csv**: Provides facts about the location and season of the cricket matches along with team information and the play results from each team member.

-   **ODI_Match_info.csv**: Overlaps in data with the above but provides information on the umpire, performance, and the city the match took place.

# Codebook for ODI_Match_Data.csv:

| Variable Name | Data type | Description                                                                                    |
|:------------------|:------------------|:----------------------------------|
| match_id      | double    | A unique identifier for each ODI cricket match.                                                |
| season        | character | The season in which the match took place                                                       |
| start_date    | character | The date on which the match started.                                                           |
| venue         | character | The stadium or venue where the match was played.                                               |
| innings       | double    | The innings number (1st innings or 2nd innings).                                               |
| ball          | double    | A numeric representation of the ball number bowled in the innings.                             |
| batting_team  | character | The name of the batting team for the current innings.                                          |
| bowling_team  | character | The name of the bowling team for the current innings.                                          |
| striker       | character | The batsman who is currently facing the ball.                                                  |
| non_striker   | character | The batsman at the non-striker's end.                                                          |
| bowler        | character | The bowler who is delivering the ball.                                                         |
| runs_off_bat  | double    | The number of runs scored off the bat (excluding extras).                                      |
| extras        | double    | The total number of extra runs (wides, no-balls, byes, leg-byes, penalty) in the current ball. |
| wides         | double    | The number of wide deliveries bowled in the current ball.                                      |
| noballs       | double    | The number of no-ball deliveries bowled in the current ball.                                   |
| byes          | double    | The number of byes scored in the current ball.                                                 |
| legbyes       | double    | The number of leg-byes scored in the current ball.                                             |

# Codebook for ODI_Match_info.csv:

| Variable Name   | Data type | Description                                                                                        |
|:------------------|:------------------|:----------------------------------|
| id              | double    | A unique identifier for each cricket match.                                                        |
| season          | character | The season in which the match took place                                                           |
| city            | character | The city where the match was held.                                                                 |
| date            | date      | The date on which the match was played.                                                            |
| team1           | character | The name of the first cricket team participating in the match.                                     |
| team2           | character | The name of the second cricket team participating in the match.                                    |
| toss_winner     | character | The team that won the toss.                                                                        |
| toss_decision   | character | The decision made by the toss-winning team (bat or field).                                         |
| result          | character | The result of the match (e.g., "normal," "tie," "no result").                                      |
| dl_applied      | double    | An indicator of whether the Duckworth-Lewis method was applied (1 for applied, 0 for not applied). |
| winner          | character | The winning team of the match.                                                                     |
| win_by_runs     | double    | The margin of victory in runs (0 for wickets, if not applicable).                                  |
| win_by_wickets  | double    | The margin of victory in wickets (0 for runs, if not applicable).                                  |
| player_of_match | character | The player awarded the "Man of the Match" title.                                                   |
| venue           | character | The stadium or venue where the match was played.                                                   |
| umpire1         | character | The name of the first on-field umpire.                                                             |
| umpire2         | character | The name of the second on-field umpire.                                                            |
| umpire3         | character | The name of the third umpire (TV umpire).                                                          |
