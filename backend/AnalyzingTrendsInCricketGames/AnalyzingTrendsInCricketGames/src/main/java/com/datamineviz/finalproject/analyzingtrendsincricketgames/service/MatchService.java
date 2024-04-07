package com.datamineviz.finalproject.analyzingtrendsincricketgames.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.repository.MatchRepository;

@org.springframework.stereotype.Service
public class MatchService {
	
	@Autowired
	MatchRepository matchRepository;
	
	public void insertDataInMatchTable(CricketMatch match) {
		
		matchRepository.save(match);
	}

}
