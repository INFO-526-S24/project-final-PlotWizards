package com.datamineviz.finalproject.analyzingtrendsincricketgames.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;
import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch2023;


@Repository
public interface MatchRepository extends JpaRepository<CricketMatch, Long>{
	
	@Query(value = "SELECT DISTINCT season FROM cricket_match", nativeQuery = true)
	public List<String> getAllSeasons();
	
	@Query(value = "SELECT DISTINCT match_id FROM cricket_match WHERE season = ?1", nativeQuery = true)
	public List<String> getMatchIdListBySeason(String season);
	
	@Query(value = "SELECT * FROM cricket_match_2023 WHERE match_id = ?1 ORDER BY innings ASC, ball ASC", nativeQuery = true)
	public List<CricketMatch> getSpectficMatchList(long matchg_id);

}
