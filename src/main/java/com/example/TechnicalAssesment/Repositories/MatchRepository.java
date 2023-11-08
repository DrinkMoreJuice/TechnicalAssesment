package com.example.TechnicalAssesment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TechnicalAssesment.Entities.Match;

/**
 * Repository interface for performing CRUD operations on Match entities.
 * 
 * @author Drink
 *
 */
public interface MatchRepository extends JpaRepository<Match, Integer>{

}
