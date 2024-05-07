package com.datamineviz.finalproject.analyzingtrendsincricketgames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatchLive;
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
	
	@GetMapping("/addstaticdata/{passcode}")
	public ResponseEntity<String> addStaticData(@PathVariable String passcode) {
		
//		if(passcode.contentEquals("eclipseWhisper24")) {
//			
//			if(matchService.addMatchToDataBase()) {
//				return new ResponseEntity<>("Match Data Added!", HttpStatus.OK);
//			}
//			return new ResponseEntity<>("Error in adding match data", HttpStatus.INTERNAL_SERVER_ERROR);
//		}else {
//			return new ResponseEntity<>("Wrong Passcode", HttpStatus.FORBIDDEN);
//		}
		
		return null;
//		
		
	}
	
	
	@GetMapping("/getmatchbyid/{id}")
	public ResponseEntity<Optional<CricketMatch>> getMatchById(@PathVariable String id) {
		
		
		
		return new ResponseEntity<>(matchService.getMatchDataById(Long.parseLong(id)), HttpStatus.OK);		
		
	}
	
	
	@GetMapping("/getallmatchdata")
	public ResponseEntity<List<CricketMatch>> getAllMatchData(){
		
		
		return new ResponseEntity<>(matchService.getAllMatchData(), HttpStatus.OK);
	}
	
	@GetMapping("/startlivematch/{matchid}/{passcode}")
	public ResponseEntity<String> startLiveMatch(@PathVariable long matchid, @PathVariable String passcode){
		
		if(passcode.contentEquals("eclipseWhisper24")) {
				
			matchService.startLiveMatchData(matchid);
			return new ResponseEntity<>("Live Match Started", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Wrong Passcode", HttpStatus.FORBIDDEN);
		}
				
	}
	
	@GetMapping("/startlivematchold/{matchid}/{passcode}")
	public ResponseEntity<String> startLiveMatchNon2023(@PathVariable long matchid, @PathVariable String passcode){
		
		if(passcode.contentEquals("eclipseWhisper24")) {
				
			matchService.startLiveMatchDataNon2023(matchid);
			return new ResponseEntity<>("Live Match Started?", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Wrong Passcode", HttpStatus.FORBIDDEN);
		}
			
			
		
	}
	
	@GetMapping("/getcurrentlivedata")
	public ResponseEntity<CricketMatchLive> getCurrentEntry(){
		
		return new ResponseEntity<>(matchService.getCurrentLiveData(), HttpStatus.OK);
	}
	
	@GetMapping("/getentirelivedata")
	public ResponseEntity<List<CricketMatchLive>> getEntireLiveData(){
		
		return new ResponseEntity<>(matchService.getEntireLiveData(), HttpStatus.OK);
	}
	
	@GetMapping("/getallseasons")
	public ResponseEntity<List<String>> getAllSeasons(){
		
		return new ResponseEntity<List<String>>(matchService.getAllSeasons(), HttpStatus.OK);
	}
	
	@GetMapping("/getmatchidsbyseason/{season}")
	public ResponseEntity<List<String>> getMatchIdsBySeason(@PathVariable String season){
		
		return new ResponseEntity<List<String>>(matchService.getMatchIdListBySeason(season), HttpStatus.OK);
	}


}
