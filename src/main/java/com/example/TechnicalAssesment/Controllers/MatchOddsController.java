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

import com.example.TechnicalAssesment.Entities.MatchOdds;
import com.example.TechnicalAssesment.Services.MatchOddsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controller class for handling HTTP requests related to MatchOdds. Provides
 * endpoints for performing CRUD operations on {@link MatchOdds} entities.
 * 
 * @author Drink
 *
 */
@RestController
@RequestMapping("/matchodds")
public class MatchOddsController {

	@Autowired
	private MatchOddsService matchOddsService;

	/**
	 * Retrieves a list of all MatchOdds.
	 *
	 * @return List of MatchOdds.
	 */
	@Operation(summary = "Get a list of all MatchOdds", description = "Retrieves a list of all MatchOdds.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Not found - The MatchOdds were not found") })
	@GetMapping
	public List<MatchOdds> getAllMatchOdds() {
		return matchOddsService.getAllMatchOdds();
	}

	/**
	 * Retrieves a MatchOdds by its unique identifier.
	 *
	 * @param id The unique identifier of the MatchOdds.
	 * @return The MatchOdds, or null if not found.
	 */
	@Operation(summary = "Get a MatchOdds by ID", description = "Retrieves a MatchOdds by its unique identifier.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Not found - The MatchOdds was not found") })
	@GetMapping("/{id}")
	public MatchOdds getMatchOddsById(
			@PathVariable @Parameter(description = "The unique identifier of the MatchOdds.", example = "1", required = true) int id) {
		return matchOddsService.getMatchOddsById(id);
	}

	/**
	 * Creates a new MatchOdds.
	 *
	 * @param matchOdds The MatchOdds to be created.
	 * @return The created MatchOdds.
	 */
	@Operation(summary = "Create a new MatchOdds", description = "Creates a new MatchOdds.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully created"),
			@ApiResponse(responseCode = "400", description = "Bad request - Invalid MatchOdds data") })
	@PostMapping
	public MatchOdds createMatchOdds(
			@RequestBody @Parameter(description = "The MatchOdds to be created.", required = true) MatchOdds matchOdds) {
		return matchOddsService.createMatchOdds(matchOdds);
	}

	/**
	 * Updates an existing MatchOdds with the provided details.
	 *
	 * @param id        The unique identifier of the MatchOdds to be updated.
	 * @param matchOdds The updated MatchOdds details.
	 * @return The updated MatchOdds, or null if MatchOdds with id doesn't exist.
	 */
	@Operation(summary = "Update an existing MatchOdds", description = "Updates an existing MatchOdds with the provided details.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Not found - The MatchOdds was not found") })
	@PutMapping("/{id}")
	public MatchOdds updateMatchOdds(
			@PathVariable @Parameter(description = "The unique identifier of the MatchOdds.", example = "1", required = true) int id,
			@RequestBody @Parameter(description = "The updated MatchOdds details.", required = true) MatchOdds matchOdds) {
		return matchOddsService.updateMatchOdds(id, matchOdds);
	}

	/**
	 * Deletes a MatchOdds by its unique identifier.
	 *
	 * @param id The unique identifier of the MatchOdds to be deleted.
	 */
	@Operation(summary = "Delete a MatchOdds by ID", description = "Deletes a MatchOdds based on its unique identifier.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Not found - The MatchOdds was not found") })
	@DeleteMapping("/{id}")
	public void deleteMatchOdds(
			@PathVariable @Parameter(description = "The unique identifier of the MatchOdds.", example = "1", required = true) int id) {
		matchOddsService.deleteMatchOdds(id);
	}

	/**
	 * Retrieves a list of match odds for a specific match.
	 *
	 * @param matchId The unique identifier of the match.
	 * @return List of match odds for the specified match.
	 */
	@Operation(summary = "Get MatchOdds by Match ID", description = "Retrieves a list of match odds for a specific match.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Not found - The MatchOdds for the match were not found") })
	@GetMapping("/match/{matchId}")
	public List<MatchOdds> getMatchOddsByMatchId(
			@PathVariable @Parameter(description = "The unique identifier of the match.", example = "1", required = true) int matchId) {
		return matchOddsService.getMatchOddsByMatchId(matchId);
	}
}