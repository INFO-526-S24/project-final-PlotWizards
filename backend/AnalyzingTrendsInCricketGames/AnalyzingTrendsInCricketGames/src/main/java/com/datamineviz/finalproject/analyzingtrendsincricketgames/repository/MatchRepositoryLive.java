package com.datamineviz.finalproject.analyzingtrendsincricketgames.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatchLive;

@Repository
public interface MatchRepositoryLive extends JpaRepository<CricketMatchLive, Long>{
	
	
	@Query(value = "SELECT * FROM cricket_match_live ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public CricketMatchLive getSCurrentScoreEntry();
	

}
	