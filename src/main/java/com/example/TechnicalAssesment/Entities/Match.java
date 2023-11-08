package com.example.TechnicalAssesment.Entities;

import java.util.Date;

import com.example.TechnicalAssesment.Enums.Sports;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Match entity.
 * 
 * @author Drink
 *
 */
@Entity
public class Match {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "The unique identifier of the match.")
    private int id;

	@Schema(description = "The description of the match.")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Schema(description = "The date of the match.")
	private Date matchDate;
	
	@Temporal(TemporalType.TIME)
	@Schema(description = "The time of the match.")
	private Date matchTime;
	
	@Schema(description = "The name of Team A.")
	private String team_A;
	
	@Schema(description = "The name of Team B.")
	private String team_B;
	
	@Enumerated(EnumType.STRING)
	@Schema(description = "The type of sport.", allowableValues = {"Football", "Basketball"})
	private Sports sport;
	
	/*
	 * Default Constructor
	 */
	public Match() {
		
	}
	
	/*
	 * Constructor
	 */
	public Match(int id, String description, Date matchDate, Date matchTime, String team_A, String team_B,
			Sports sport) {
		this.id = id;
		this.description = description;
		this.matchDate = matchDate;
		this.matchTime = matchTime;
		this.team_A = team_A;
		this.team_B = team_B;
		this.sport = sport;
	}

	/**
	 * Gets the id of the match.
	 * 
	 * @return	The id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the match.
	 * 
	 * @param id	The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the match description.
	 * 
	 * @return	The match description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * The match description to set.
	 * 
	 * @param description	The match description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the match date.
	 * 
	 * @return	The match date.
	 */
	public Date getMatchDate() {
		return matchDate;
	}

	/**
	 * Sets the match date.
	 * 
	 * @param matchDate	The match date to set.
	 */
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	/**
	 * Gets the match time.
	 * 
	 * @return	The match time.
	 */
	public Date getMatchTime() {
		return matchTime;
	}

	/**
	 * Sets the match time.
	 * 
	 * @param matchTime	The match time to set.
	 */
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	/**
	 * Gets the team A.
	 * 
	 * @return	The team A.
	 */
	public String getTeamA() {
		return team_A;
	}

	/**
	 * Sets the team A.
	 * 
	 * @param teamA	The team A to set.
	 */
	public void setTeamA(String team_A) {
		this.team_A = team_A;
	}

	/**
	 * Gets the team B.
	 * 
	 * @return	The team B.
	 */
	public String getTeamB() {
		return team_B;
	}

	/**
	 * Sets the team B.
	 * 
	 * @param teamB	The team B to set.
	 */
	public void setTeamB(String team_B) {
		this.team_B = team_B;
	}

	/**
	 * Gets the sport.
	 * 
	 * @return	The sport.
	 */
	public Sports getSport() {
		return sport;
	}

	/**
	 * Sets the sport.
	 * 
	 * @param sport	The sport to set.
	 */
	public void setSport(Sports sport) {
		this.sport = sport;
	}

}
