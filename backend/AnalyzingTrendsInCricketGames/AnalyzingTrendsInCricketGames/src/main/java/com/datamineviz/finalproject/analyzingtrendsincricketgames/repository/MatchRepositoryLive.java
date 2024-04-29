package com.datamineviz.finalproject.analyzingtrendsincricketgames.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch2023;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatchLive;

@Repository
public interface MatchRepositoryLive extends JpaRepository<CricketMatchLive, Long>{
	
	

}
