package com.datamineviz.finalproject.analyzingtrendsincricketgames.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CricketMatch2023 {
	
	 private long matchId;
	    private String season;
	    private String venue;
	    private int innings;
	    private float ball;
	    private String battingTeam;
	    private String bowlingTeam;
	    private String striker;
	    private String nonStriker;
	    private String bowler;
	    private int runsOffBat;
	    private int extras;
	    private int wides;
	    private int noballs;
	    private String city;
	    private Date date;
	    private String team1;
	    private String team2;
	    private String tossWinner;
	    private String tossDecision;
	    private String result;
	    private int dlApplied;
	    private String winner;
	    private int winByRuns;
	    private int winByWickets;
	    private String playerOfMatch;
	    
		@Id
		@GeneratedValue
		private long id;
	    
		public CricketMatch2023() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "CricketMatch [matchId=" + matchId + ", season=" + season + ", venue=" + venue + ", innings=" + innings
					+ ", ball=" + ball + ", battingTeam=" + battingTeam + ", bowlingTeam=" + bowlingTeam + ", striker="
					+ striker + ", nonStriker=" + nonStriker + ", bowler=" + bowler + ", runsOffBat=" + runsOffBat
					+ ", extras=" + extras + ", wides=" + wides + ", noballs=" + noballs + ", city=" + city + ", date="
					+ date + ", team1=" + team1 + ", team2=" + team2 + ", tossWinner=" + tossWinner + ", tossDecision="
					+ tossDecision + ", result=" + result + ", dlApplied=" + dlApplied + ", winner=" + winner
					+ ", winByRuns=" + winByRuns + ", winByWickets=" + winByWickets + ", playerOfMatch=" + playerOfMatch
					+ ", id=" + id + "]";
		}

		public CricketMatch2023(long matchId, String season, String venue, int innings, float ball, String battingTeam,
				String bowlingTeam, String striker, String nonStriker, String bowler, int runsOffBat, int extras,
				int wides, int noballs, String city, Date date, String team1, String team2, String tossWinner,
				String tossDecision, String result, int dlApplied, String winner, int winByRuns, int winByWickets,
				String playerOfMatch, long id) {
			super();
			this.matchId = matchId;
			this.season = season;
			this.venue = venue;
			this.innings = innings;
			this.ball = ball;
			this.battingTeam = battingTeam;
			this.bowlingTeam = bowlingTeam;
			this.striker = striker;
			this.nonStriker = nonStriker;
			this.bowler = bowler;
			this.runsOffBat = runsOffBat;
			this.extras = extras;
			this.wides = wides;
			this.noballs = noballs;
			this.city = city;
			this.date = date;
			this.team1 = team1;
			this.team2 = team2;
			this.tossWinner = tossWinner;
			this.tossDecision = tossDecision;
			this.result = result;
			this.dlApplied = dlApplied;
			this.winner = winner;
			this.winByRuns = winByRuns;
			this.winByWickets = winByWickets;
			this.playerOfMatch = playerOfMatch;
			this.id = id;
		}

		public long getMatchId() {
			return matchId;
		}

		public void setMatchId(long matchId) {
			this.matchId = matchId;
		}

		public String getSeason() {
			return season;
		}

		public void setSeason(String season) {
			this.season = season;
		}

		public String getVenue() {
			return venue;
		}

		public void setVenue(String venue) {
			this.venue = venue;
		}

		public int getInnings() {
			return innings;
		}

		public void setInnings(int innings) {
			this.innings = innings;
		}

		public float getBall() {
			return ball;
		}

		public void setBall(float ball) {
			this.ball = ball;
		}

		public String getBattingTeam() {
			return battingTeam;
		}

		public void setBattingTeam(String battingTeam) {
			this.battingTeam = battingTeam;
		}

		public String getBowlingTeam() {
			return bowlingTeam;
		}

		public void setBowlingTeam(String bowlingTeam) {
			this.bowlingTeam = bowlingTeam;
		}

		public String getStriker() {
			return striker;
		}

		public void setStriker(String striker) {
			this.striker = striker;
		}

		public String getNonStriker() {
			return nonStriker;
		}

		public void setNonStriker(String nonStriker) {
			this.nonStriker = nonStriker;
		}

		public String getBowler() {
			return bowler;
		}

		public void setBowler(String bowler) {
			this.bowler = bowler;
		}

		public int getRunsOffBat() {
			return runsOffBat;
		}

		public void setRunsOffBat(int runsOffBat) {
			this.runsOffBat = runsOffBat;
		}

		public int getExtras() {
			return extras;
		}

		public void setExtras(int extras) {
			this.extras = extras;
		}

		public int getWides() {
			return wides;
		}

		public void setWides(int wides) {
			this.wides = wides;
		}

		public int getNoballs() {
			return noballs;
		}

		public void setNoballs(int noballs) {
			this.noballs = noballs;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getTeam1() {
			return team1;
		}

		public void setTeam1(String team1) {
			this.team1 = team1;
		}

		public String getTeam2() {
			return team2;
		}

		public void setTeam2(String team2) {
			this.team2 = team2;
		}

		public String getTossWinner() {
			return tossWinner;
		}

		public void setTossWinner(String tossWinner) {
			this.tossWinner = tossWinner;
		}

		public String getTossDecision() {
			return tossDecision;
		}

		public void setTossDecision(String tossDecision) {
			this.tossDecision = tossDecision;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public int getDlApplied() {
			return dlApplied;
		}

		public void setDlApplied(int dlApplied) {
			this.dlApplied = dlApplied;
		}

		public String getWinner() {
			return winner;
		}

		public void setWinner(String winner) {
			this.winner = winner;
		}

		public int getWinByRuns() {
			return winByRuns;
		}

		public void setWinByRuns(int winByRuns) {
			this.winByRuns = winByRuns;
		}

		public int getWinByWickets() {
			return winByWickets;
		}

		public void setWinByWickets(int winByWickets) {
			this.winByWickets = winByWickets;
		}

		public String getPlayerOfMatch() {
			return playerOfMatch;
		}

		public void setPlayerOfMatch(String playerOfMatch) {
			this.playerOfMatch = playerOfMatch;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
	    
		

	
}
