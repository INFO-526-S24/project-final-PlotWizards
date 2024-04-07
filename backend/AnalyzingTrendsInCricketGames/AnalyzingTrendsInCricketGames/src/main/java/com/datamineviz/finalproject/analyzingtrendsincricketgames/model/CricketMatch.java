package com.datamineviz.finalproject.analyzingtrendsincricketgames.model;

import jakarta.persistence.Entity;
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
public class CricketMatch {
	
	@Id
    private int match_id;
    private String season;
    private String start_date;
    private String venue;
    private int innings;
    private int ball;
    private String batting_team;
    private String bowling_team;
    private String striker;
    private String non_striker;
    private String bowler;
    private int runs_off_bat;
    private int extras;
    private int wides;
    private int noballs;
    private int byes;
    private int legbyes;
	private int penalty;
    private String wicket_type;
    private String player_dismissed;
    private String other_wicket_type;
    private String other_player_dismissed;
	private int cricsheet_id;
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
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
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public String getBatting_team() {
		return batting_team;
	}
	public void setBatting_team(String batting_team) {
		this.batting_team = batting_team;
	}
	public String getBowling_team() {
		return bowling_team;
	}
	public void setBowling_team(String bowling_team) {
		this.bowling_team = bowling_team;
	}
	public String getStriker() {
		return striker;
	}
	public void setStriker(String striker) {
		this.striker = striker;
	}
	public String getNon_striker() {
		return non_striker;
	}
	public void setNon_striker(String non_striker) {
		this.non_striker = non_striker;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public int getRuns_off_bat() {
		return runs_off_bat;
	}
	public void setRuns_off_bat(int runs_off_bat) {
		this.runs_off_bat = runs_off_bat;
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
	public int getByes() {
		return byes;
	}
	public void setByes(int byes) {
		this.byes = byes;
	}
	public int getLegbyes() {
		return legbyes;
	}
	public void setLegbyes(int legbyes) {
		this.legbyes = legbyes;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	public String getWicket_type() {
		return wicket_type;
	}
	public void setWicket_type(String wicket_type) {
		this.wicket_type = wicket_type;
	}
	public String getPlayer_dismissed() {
		return player_dismissed;
	}
	public void setPlayer_dismissed(String player_dismissed) {
		this.player_dismissed = player_dismissed;
	}
	public String getOther_wicket_type() {
		return other_wicket_type;
	}
	public void setOther_wicket_type(String other_wicket_type) {
		this.other_wicket_type = other_wicket_type;
	}
	public String getOther_player_dismissed() {
		return other_player_dismissed;
	}
	public void setOther_player_dismissed(String other_player_dismissed) {
		this.other_player_dismissed = other_player_dismissed;
	}
	public int getCricsheet_id() {
		return cricsheet_id;
	}
	public void setCricsheet_id(int cricsheet_id) {
		this.cricsheet_id = cricsheet_id;
	}
	public CricketMatch(int match_id, String season, String start_date, String venue, int innings, int ball,
			String batting_team, String bowling_team, String striker, String non_striker, String bowler,
			int runs_off_bat, int extras, int wides, int noballs, int byes, int legbyes, int penalty,
			String wicket_type, String player_dismissed, String other_wicket_type, String other_player_dismissed,
			int cricsheet_id) {
		super();
		this.match_id = match_id;
		this.season = season;
		this.start_date = start_date;
		this.venue = venue;
		this.innings = innings;
		this.ball = ball;
		this.batting_team = batting_team;
		this.bowling_team = bowling_team;
		this.striker = striker;
		this.non_striker = non_striker;
		this.bowler = bowler;
		this.runs_off_bat = runs_off_bat;
		this.extras = extras;
		this.wides = wides;
		this.noballs = noballs;
		this.byes = byes;
		this.legbyes = legbyes;
		this.penalty = penalty;
		this.wicket_type = wicket_type;
		this.player_dismissed = player_dismissed;
		this.other_wicket_type = other_wicket_type;
		this.other_player_dismissed = other_player_dismissed;
		this.cricsheet_id = cricsheet_id;
	}
	@Override
	public String toString() {
		return "CricketMatch [match_id=" + match_id + ", season=" + season + ", start_date=" + start_date + ", venue="
				+ venue + ", innings=" + innings + ", ball=" + ball + ", batting_team=" + batting_team
				+ ", bowling_team=" + bowling_team + ", striker=" + striker + ", non_striker=" + non_striker
				+ ", bowler=" + bowler + ", runs_off_bat=" + runs_off_bat + ", extras=" + extras + ", wides=" + wides
				+ ", noballs=" + noballs + ", byes=" + byes + ", legbyes=" + legbyes + ", penalty=" + penalty
				+ ", wicket_type=" + wicket_type + ", player_dismissed=" + player_dismissed + ", other_wicket_type="
				+ other_wicket_type + ", other_player_dismissed=" + other_player_dismissed + ", cricsheet_id="
				+ cricsheet_id + "]";
	}
	public CricketMatch() {
		super();
		// TODO Auto-generated constructor stub
	}

}
