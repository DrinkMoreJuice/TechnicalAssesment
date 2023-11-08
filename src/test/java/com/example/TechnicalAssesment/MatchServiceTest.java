package com.example.TechnicalAssesment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.TechnicalAssesment.Entities.Match;
import com.example.TechnicalAssesment.Enums.Sports;
import com.example.TechnicalAssesment.Repositories.MatchRepository;
import com.example.TechnicalAssesment.Services.MatchService;
import com.example.TechnicalAssesment.Services.MatchServiceImpl;

/**
 * Tests for Match Service use cases.
 * 
 * @author Drink
 *
 */
@SpringBootTest
public class MatchServiceTest {

    private MatchService matchService;
    private MatchRepository matchRepository;

    @BeforeEach
    public void setUp() {
        matchRepository = mock(MatchRepository.class);
        matchService = new MatchServiceImpl(matchRepository);
    }

    @Test
    public void testGetAllMatches() {
        List<Match> matchList = new ArrayList<>();
        matchList.add(new Match(1, "Match 1", new Date(), new Date(), "Team A", "Team B", Sports.Football));
        matchList.add(new Match(2, "Match 2", new Date(), new Date(), "Team C", "Team D", Sports.Basketball));

        when(matchRepository.findAll()).thenReturn(matchList);

        List<Match> result = matchService.getAllMatches();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Match 1", result.get(0).getDescription());
        assertEquals("Team A", result.get(0).getTeamA());
        assertEquals("Team B", result.get(0).getTeamB());
    }

    @Test
    public void testGetMatchById() {
        
        Match match = new Match(1, "Match 1", new Date(), new Date(), "Team A", "Team B", Sports.Football);

        when(matchRepository.findById(1)).thenReturn(Optional.of(match));

        Match result = matchService.getMatchById(1);

        assertNotNull(result);
        assertEquals("Match 1", result.getDescription());
        assertEquals("Team A", result.getTeamA());
        assertEquals("Team B", result.getTeamB());
    }

    @Test
    public void testCreateMatch() {
        
        Match matchToCreate = new Match(1, "Match 1", new Date(), new Date(), "Team A", "Team B", Sports.Football);

        when(matchRepository.save(any(Match.class))).thenReturn(matchToCreate);

        Match result = matchService.createMatch(matchToCreate);

        assertNotNull(result);
        assertEquals("Match 1", result.getDescription());
        assertEquals("Team A", result.getTeamA());
        assertEquals("Team B", result.getTeamB());
    }

    @Test
    public void testUpdateMatch() {
        
        Match existingMatch = new Match(1, "Match 1", new Date(), new Date(), "Team A", "Team B", Sports.Football);
        Match updatedMatch = new Match(1, "Updated Match", new Date(), new Date(), "Team C", "Team D", Sports.Basketball);

        when(matchRepository.findById(1)).thenReturn(Optional.of(existingMatch));

        Match result = matchService.updateMatch(1, updatedMatch);

        assertNotNull(result);
        assertEquals("Updated Match", result.getDescription());
        assertEquals("Team C", result.getTeamA());
        assertEquals("Team D", result.getTeamB());
    }

    @Test
    public void testDeleteMatch() {
        
        matchService.deleteMatch(1);
        verify(matchRepository).deleteById(1);
    }

}
