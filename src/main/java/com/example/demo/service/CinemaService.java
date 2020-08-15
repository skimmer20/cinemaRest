package com.example.demo.service;

import com.example.demo.dto.CinemaDTO;
import com.example.demo.model.Cinema;
import org.springframework.data.domain.PageRequest;

/**
 * @author yuriismac on 2020-07-11.
 * @project demo
 */
public interface CinemaService {

     CinemaDTO getCinemas(PageRequest pageRequest);

     Cinema insertCinema(Cinema cinema, int ownerId);

     Cinema updateCinema(Cinema cinema);

     void deleteCinema(Integer id);




}
