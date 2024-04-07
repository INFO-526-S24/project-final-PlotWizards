package com.datamineviz.finalproject.analyzingtrendsincricketgames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.service.MatchService;

@RestController
public class Controller {
	
	@Autowired
	MatchService matchService;
	
	
	@GetMapping("/test/{id}")
	public String test(@PathVariable String id){
		String x = "Working! ";
		return x + id;
	}
	
	@GetMapping("/addstaticdata")
	public void addStaticData() {
		
		CricketMatch match = new CricketMatch(
                1389389,             // match_id
                "2023/24",          // season
                "24-09-2023",       // start_date
                "Holkar Cricket Stadium, Indore", // venue
                1,                  // innings
                1,                  // ball
                "India",            // batting_team
                "Australia",        // bowling_team
                "RD Gaikwad",       // striker
                "Shubman Gill",     // non_striker
                "SH Johnson",       // bowler
                4,                  // runs_off_bat
                0,                  // extras
                0,                  // wides
                0,                  // noballs
                0,                  // byes
                0,                  // legbyes
                0,                  // penalty
                "",                 // wicket_type
                "",                 // player_dismissed
                "",                 // other_wicket_type
                "",                 // other_player_dismissed
                1389389             // cricsheet_id
        );
		
		
		matchService.insertDataInMatchTable(match);
		
	}

}
