package com.datamineviz.finalproject.analyzingtrendsincricketgames.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datamineviz.finalproject.analyzingtrendsincricketgames.model.CricketMatch;

@Repository
public interface MatchRepository extends JpaRepository<CricketMatch, Long>{

}
