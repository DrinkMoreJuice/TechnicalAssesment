package com.example.TechnicalAssesment.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TechnicalAssesment.Entities.MatchOdds;

/**
 * Repository interface for performing CRUD operations on MatchOdds entities.
 * 
 * @author Drink
 *
 */
public interface MatchOddsRepository extends JpaRepository<MatchOdds, Integer>{
	
	/**
     * Retrieves a list of match odds for a specific match.
     *
     * @param matchId The unique identifier of the match.
     * @return List of match odds for the specified match.
     */
    List<MatchOdds> findByMatchId(int matchId);
    
}
