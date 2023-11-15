package com.example.TechnicalAssesment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TechnicalAssesment.Entities.MatchOdds;
import com.example.TechnicalAssesment.Repositories.MatchOddsRepository;

/**
 * Implementation of {@link MatchOddsService}.
 * 
 * @author Drink
 *
 */
@Service
public class MatchOddsServiceImpl implements MatchOddsService {

    @Autowired
    private MatchOddsRepository matchOddsRepository;

    /*
     * @see com.example.TechnicalAssesment.Services.MatchOddsService.getAllMatchOdds()
     */
    @Override
    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    /*
     * @see com.example.TechnicalAssesment.Services.MatchOddsService.getMatchOddsById(int)
     */
    @Override
    public MatchOdds getMatchOddsById(int id) {
        return matchOddsRepository.findById(id).orElse(null);
    }

    /*
     * @see com.example.TechnicalAssesment.Services.MatchOddsService.createMatchOdds(MatchOdds)
     */
    @Override
    public MatchOdds createMatchOdds(MatchOdds matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }

    /*
     * @see com.example.TechnicalAssesment.Services.MatchOddsService.updateMatchOdds(int, MatchOdds)
     */
    @Override
    public MatchOdds updateMatchOdds(int id, MatchOdds updatedMatchOdds) {
        MatchOdds existingMatchOdds = matchOddsRepository.findById(id).orElse(null);
        if (existingMatchOdds != null) {
        	updateTheMatchOdds(existingMatchOdds, updatedMatchOdds);
        	matchOddsRepository.save(existingMatchOdds);
        	return existingMatchOdds;
        }
     // Return null if MatchOdds with id doesn't exist
        return null; 
    }

    /*
     * @see com.example.TechnicalAssesment.Services.MatchOddsService.deleteMatchOdds(int)
     */
    @Override
    public void deleteMatchOdds(int id) {
        matchOddsRepository.deleteById(id);
    }
    
    /*
     * @see com.example.TechnicalAssesment.Services.MatchOddsService.getMatchOddsByMatchId(int)
     */
    @Override
	public List<MatchOdds> getMatchOddsByMatchId(int matchId) {
    	return matchOddsRepository.findByMatchId(matchId);
	}
    
    /**
     * Method that updates the existing match odds with the updated match odds values.
	 * 
     * @param existingMatchOdds		The existing Match Odds.
     * @param updatedMatchOdds		The updated Match Odds.
     */
    private void updateTheMatchOdds(MatchOdds existingMatchOdds, MatchOdds updatedMatchOdds) {
    	existingMatchOdds.setMatch(updatedMatchOdds.getMatch());
    	existingMatchOdds.setOdd(updatedMatchOdds.getOdd());
    	existingMatchOdds.setSpecifier(updatedMatchOdds.getSpecifier());
    }
	
}
