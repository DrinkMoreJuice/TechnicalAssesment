package com.example.TechnicalAssesment.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TechnicalAssesment.Entities.Match;

/**
 * Service interface for handling operations related to matches.
 * 
 * @author Drink
 *
 */
@Service
public interface MatchService {

	/**
	 * Retrieves a list of all matches.
	 *
	 * @return List of matches.
	 */
	List<Match> getAllMatches();

	/**
	 * Retrieves a match by its unique identifier.
	 *
	 * @param id The unique identifier of the match.
	 * @return The match, or null if not found.
	 */
	Match getMatchById(int id);

	/**
	 * Creates a new match.
	 *
	 * @param match The match to be created.
	 * @return The created match.
	 */
	Match createMatch(Match match);

	/**
	 * Updates an existing match with the provided details.
	 *
	 * @param id           The unique identifier of the match to be updated.
	 * @param updatedMatch The updated match details.
	 * @return The updated match, or null if match with id doesn't exist.
	 */
	Match updateMatch(int id, Match updatedMatch);

	/**
	 * Deletes a match by its unique identifier.
	 *
	 * @param id The unique identifier of the match to be deleted.
	 */
	void deleteMatch(int id);

}
