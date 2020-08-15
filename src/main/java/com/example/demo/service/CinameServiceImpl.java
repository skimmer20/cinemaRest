package com.example.demo.service;

import com.example.demo.dto.CinemaDTO;
import com.example.demo.model.Cinema;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author yuriismac on 2020-07-11.
 * @project demo
 */
@Service
@Slf4j
public class CinameServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public CinemaDTO getCinemas(PageRequest pageRequest) {
        Page<Cinema> cinemaPages = cinemaRepository.findAll(pageRequest);
        CinemaDTO cinemaDTO = new CinemaDTO();
        cinemaDTO.setCinemas(cinemaPages.getContent());
        cinemaDTO.setEmpty(cinemaPages.isEmpty());
        cinemaDTO.setLast(cinemaPages.isLast());
        cinemaDTO.setTotalCount(cinemaPages.getTotalPages());
        cinemaDTO.setTotalElements(cinemaPages.getNumberOfElements());
        return cinemaDTO;
    }

    @Override
    public Cinema insertCinema(Cinema cinema, int ownerId) {
        if (cinemaRepository.findByTitle(cinema.getTitle()).isPresent()){
            log.info("Cinema with " + cinema.getTitle() + "  exists is database!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The cinema title already exists!");
        }
        ownerRepository.findById(ownerId).ifPresent(owner -> {
            cinema.setOwner(owner);
            cinemaRepository.save(cinema);
        });
        return cinema;
    }

    @Override
    public Cinema updateCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public void deleteCinema(Integer id) {
        cinemaRepository.deleteById(id);
    }
}
