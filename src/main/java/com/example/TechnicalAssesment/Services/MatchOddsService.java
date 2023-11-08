package com.example.TechnicalAssesment.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TechnicalAssesment.Entities.MatchOdds;

/**
 * Service interface for handling operations related to match odds.
 * 
 * @author Drink
 *
 */
@Service
public interface MatchOddsService {

	/**
     * Retrieves a list of all MatchOdds.
     *
     * @return List of MatchOdds.
     */
	List<MatchOdds> getAllMatchOdds();
	
	/**
     * Retrieves a MatchOdds by its unique identifier.
     *
     * @param id The unique identifier of the MatchOdds.
     * @return The MatchOdds, or null if not found.
     */
    MatchOdds getMatchOddsById(int id);
    
    /**
     * Creates a new MatchOdds.
     *
     * @param matchOdds The MatchOdds to be created.
     * @return The created MatchOdds.
     */
    MatchOdds createMatchOdds(MatchOdds matchOdds);
    
    /**
     * Updates an existing MatchOdds with the provided details.
     *
     * @param id               The unique identifier of the MatchOdds to be updated.
     * @param updatedMatchOdds The updated MatchOdds details.
     * @return The updated MatchOdds, or null if MatchOdds with id doesn't exist.
     */
    MatchOdds updateMatchOdds(int id, MatchOdds updatedMatchOdds);
    
    /**
     * Deletes a MatchOdds by its unique identifier.
     *
     * @param id The unique identifier of the MatchOdds to be deleted.
     */
    void deleteMatchOdds(int id);
    
    /**
     * Retrieves a list of match odds for a specific match.
     *
     * @param matchId 	The unique identifier of the match.
     * @return 	List of match odds for the specified match.
     */
    List<MatchOdds> getMatchOddsByMatchId(int matchId);
}
