package com.datamineviz.finalproject.analyzingtrendsincricketgames.service;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch2023;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatchLive;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.repository.MatchRepository;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.repository.MatchRepository2023;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.repository.MatchRepositoryLive;
import com.opencsv.CSVReader;

@org.springframework.stereotype.Service
public class MatchService {
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	MatchRepository2023 matchRepository2023;
	
	@Autowired
	MatchRepositoryLive matchRepositoryLive;
	
	
	public void insertDataInMatchTable(CricketMatch match) {
		
		matchRepository.save(match);
	}
	
	public List<CricketMatch> getAllMatchData(){
		return matchRepository.findAll();
	}
	public Optional<CricketMatch> getMatchDataById(long id){
		return matchRepository.findById(id);
	}
	

	private int Integer(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public void startLiveMatchData(long id) {
		
		try {
			matchRepositoryLive.deleteAll();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		List<CricketMatch2023> matchList = matchRepository2023.getSpectficMatchList(id);
		
		int totalRunsInning1 = 0;
		
		int totalRunsInning2 = 0;
		
		for (CricketMatch2023 entry : matchList) {
			if(entry.getInnings() == 1) {
				totalRunsInning1 += entry.getRunsOffBat() + entry.getExtras();
				matchRepositoryLive.save(new CricketMatchLive(entry, totalRunsInning1));
			}else {
				totalRunsInning2 += entry.getRunsOffBat() + entry.getExtras();
				matchRepositoryLive.save(new CricketMatchLive(entry, totalRunsInning2));
			}
	
			
			System.out.println(entry);
            try {
                Thread.sleep(50); // Sleep for 10 seconds (10000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
	}
	
	
	public void startLiveMatchDataNon2023(long id) {
		
		try {
			matchRepositoryLive.deleteAll();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		List<CricketMatch> matchList = matchRepository.getSpectficMatchList(id);
		
		int totalRunsInning1 = 0;
		
		int totalRunsInning2 = 0;
		
		for (CricketMatch entry : matchList) {
			if(entry.getInnings() == 1) {
				totalRunsInning1 += entry.getRunsOffBat() + entry.getExtras();
				matchRepositoryLive.save((new CricketMatchLive(entry, totalRunsInning1)));
			}else {
				totalRunsInning2 += entry.getRunsOffBat() + entry.getExtras();
				matchRepositoryLive.save(new CricketMatchLive(entry, totalRunsInning2));
			}
	
			
			System.out.println(entry);
            try {
                Thread.sleep(100); // Sleep for 10 seconds (10000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
	}
	
	
	
	public CricketMatchLive getCurrentLiveData() {
		return matchRepositoryLive.getSCurrentScoreEntry();
	}
	
	public List<CricketMatchLive> getEntireLiveData() {
		return matchRepositoryLive.findAll();
	}
	
	public List<String> getAllSeasons(){
		return matchRepository.getAllSeasons();
	}

	public List<String> getMatchIdListBySeason(String season) {
		return matchRepository.getMatchIdListBySeason(season);
	}
	
	
}
