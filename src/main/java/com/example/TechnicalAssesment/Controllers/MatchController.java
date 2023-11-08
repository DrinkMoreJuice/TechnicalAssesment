package com.example.TechnicalAssesment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TechnicalAssesment.Entities.Match;
import com.example.TechnicalAssesment.Services.MatchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controller class for handling HTTP requests related to matches. Provides
 * endpoints for performing CRUD operations on {@link Match} entities.
 * 
 * @author Drink
 *
 */
@RestController
@RequestMapping("/matches")
public class MatchController {

	@Autowired
	private MatchService matchService;

	/**
	 * Retrieves a list of all matches.
	 *
	 * @return List of matches.
	 */
	@Operation(summary = "Get a list of all matches", description = "This endpoint retrieves a list of all matches.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Not found - The product was not found") })
	@GetMapping
	public List<Match> getAllMatches() {
		return matchService.getAllMatches();
	}

	/**
	 * Retrieves a match by its unique identifier.
	 *
	 * @param id The unique identifier of the match.
	 * @return The match, or null if not found.
	 */
	@Operation(summary = "Get a match by ID", description = "Retrieves a match based on its unique identifier.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Not found - The match was not found") })
	@GetMapping("/{id}")
	public Match getMatchById(
			@PathVariable @Parameter(description = "The unique identifier of the match.", example = "1") int id) {
		return matchService.getMatchById(id);
	}

	/**
	 * Creates a new match.
	 *
	 * @param match The match to be created.
	 * @return The created match.
	 */
	@Operation(summary = "Create a new match", description = "Creates a new match.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "400", description = "Bad request - Invalid match data") })
	@PostMapping
	public Match createMatch(
			@RequestBody @Parameter(description = "The match to be created.", required = true) Match match) {
		return matchService.createMatch(match);
	}

	/**
	 * Updates an existing match with the provided details.
	 *
	 * @param id    The unique identifier of the match to be updated.
	 * @param match The updated match details.
	 * @return The updated match, or null if match with id doesn't exist.
	 */
	@Operation(summary = "Update an existing match", description = "Updates an existing match with the provided details.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Not found - The match was not found") })
	@PutMapping("/{id}")
	public Match updateMatch(
			@PathVariable @Parameter(description = "The unique identifier of the match.", example = "1", required = true) int id,
			@RequestBody @Parameter(description = "The updated match details.", required = true) Match match) {
		return matchService.updateMatch(id, match);
	}

	/**
	 * Deletes a match by its unique identifier.
	 *
	 * @param id The unique identifier of the match to be deleted.
	 */
	@Operation(summary = "Delete a match by ID", description = "Deletes a match based on its unique identifier.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Not found - The match was not found") })
	@DeleteMapping("/{id}")
	public void deleteMatch(
			@PathVariable @Parameter(description = "The unique identifier of the match.", example = "1", required = true) int id) {
		matchService.deleteMatch(id);
	}
}
