package com.example.TechnicalAssesment.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * MatchOdds entity.
 * 
 * @author Drink
 *
 */
@Entity
public class MatchOdds {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "The unique identifier of the match odds.")
    private int id;

	@ManyToOne
    @JoinColumn(name = "match_id", referencedColumnName = "id")
	@Schema(description = "The associated match for these odds.")
    private Match match;
	
	@Schema(description = "The specifier for these odds.")
	private String specifier;
	
	@Schema(description = "The odds value.")
	private float odd;
	
	/**
	 * Gets the id of the match odds.
	 * 
	 * @return	The id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the match odds.
	 * 
	 * @param id	The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the match.
	 * 
	 * @return	The match.
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * Sets the match.
	 * 
	 * @param match	The match to set.
	 */
	public void setMatch(Match match) {
		this.match = match;
	}

	/**
	 * Gets the specifier.
	 * 
	 * @return
	 */
	public String getSpecifier() {
		return specifier;
	}

	/**
	 * Sets the specifier.
	 * 
	 * @param specifier	The specifier to set.
	 */
	public void setSpecifier(String specifier) {
		this.specifier = specifier;
	}

	/**
	 * Gets the odd .
	 * 
	 * @return	The odd.
	 */
	public float getOdd() {
		return odd;
	}

	/**
	 * Sets the odd.
	 * 
	 * @param odd	The odd to set.
	 */
	public void setOdd(float odd) {
		this.odd = odd;
	}
	
}
