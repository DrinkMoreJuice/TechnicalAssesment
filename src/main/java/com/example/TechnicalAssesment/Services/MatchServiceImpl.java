package com.example.TechnicalAssesment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TechnicalAssesment.Entities.Match;
import com.example.TechnicalAssesment.Repositories.MatchRepository;

/**
 * Implementation of {@link MatchService}.
 * 
 * @author Drink
 *
 */
@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

	public MatchServiceImpl(MatchRepository matchRepository) {
		this.matchRepository = matchRepository;
	}

	/*
	 * @see com.example.TechnicalAssesment.Services.MatchService.getAllMatches()
	 */
	@Override
	public List<Match> getAllMatches() {
		return matchRepository.findAll();
	}

	/*
	 * @see com.example.TechnicalAssesment.Services.MatchService.getMatchById(int)
	 */
	@Override
	public Match getMatchById(int id) {
		return matchRepository.findById(id).orElse(null);
	}

	/*
	 * @see com.example.TechnicalAssesment.Services.MatchService.createMatch(Match)
	 */
	@Override
	public Match createMatch(Match match) {
		return matchRepository.save(match);
	}

	/*
	 * @see com.example.TechnicalAssesment.Services.MatchService.updateMatch(int, Match)
	 */
	@Override
	public Match updateMatch(int id, Match updatedMatch) {
		Match existingMatch = matchRepository.findById(id).orElse(null);
		if (existingMatch != null) {
			updateTheMatch(existingMatch,updatedMatch);
			return existingMatch;
		}
		// Return null if match with id doesn't exist
		return null; 
	}
	
	/*
	 * @see com.example.TechnicalAssesment.Services.MatchService.deleteMatch(int)
	 */
	@Override
	public void deleteMatch(int id) {
		matchRepository.deleteById(id);
	}
	
	/**
	 * Method that updates the existing match with the updated match values.
	 * 
	 * @param existingMatch		The existing Match.
	 * @param updatedMatch		The updated Match.
	 */
	private void updateTheMatch(Match existingMatch, Match updatedMatch) {
		existingMatch.setDescription(updatedMatch.getDescription());
		existingMatch.setMatchDate(updatedMatch.getMatchDate());
		existingMatch.setMatchTime(updatedMatch.getMatchTime());
		existingMatch.setSport(updatedMatch.getSport());
		existingMatch.setTeamA(updatedMatch.getTeamA());
		existingMatch.setTeamB(updatedMatch.getTeamB());
	}
}
