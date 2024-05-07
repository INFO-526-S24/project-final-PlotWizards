package com.datamineviz.finalproject.analyzingtrendsincricketgames.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch2023;

@Repository
public interface MatchRepository2023 extends JpaRepository<CricketMatch2023, Long>{
	
	@Query(value = "SELECT * FROM cricket_match_2023 WHERE match_id = ?1 ORDER BY innings ASC, ball ASC", nativeQuery = true)
	public List<CricketMatch2023> getSpectficMatchList(long matchg_id);

}
