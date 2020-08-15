package com.example.demo.repository;

import com.example.demo.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author yuriismac on 2020-07-10.
 * @project demo
 */
@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    Optional<Cinema> findByTitle(String title);
}
