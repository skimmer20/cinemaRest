package com.example.demo.controller;

import com.example.demo.dto.CinemaDTO;
import com.example.demo.model.Cinema;
import com.example.demo.service.CinemaService;
import com.example.demo.validation.CinemaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

/**
 * @author yuriismac on 2020-07-06.
 * @project demo
 */
@RestController
@RequestMapping(value = "/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    CinemaValidator cinemaValidator;

    @RequestMapping(method = RequestMethod.GET)
    public CinemaDTO getCinemas(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "3") int size,
                                HttpServletRequest request,
                                Principal principal) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return cinemaService.getCinemas(pageRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{ownerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema addCinema(@RequestBody @Valid Cinema cinema, @PathVariable Integer ownerId) {
        return cinemaService.insertCinema(cinema, ownerId);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Cinema updateCinema(@RequestBody Cinema cinema, @PathVariable Integer id) {
        /*Optional<Cinema> cinemaOptional = cinemas.stream()
                .filter(cinema1 -> cinema1.getId() == id)
                .findFirst();
        if (cinemaOptional.isPresent()) {
            Cinema cinemaFromList = cinemaOptional.get();
            cinemas.set(cinemas.indexOf(cinemaFromList), cinema);
        } else {
            cinemas.add(cinema);
        }
        return cinema;*/
        cinema.setId(id);
        cinemaService.updateCinema(cinema);
        return cinema;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCinema(@PathVariable Integer id){
        /*Optional<Cinema> cinemaOptional = cinemas.stream()
                .filter(cinema -> cinema.getId() == id)
                .findFirst();
        cinemaOptional.ifPresent(cinema -> cinemas.remove(cinema));*/
        cinemaService.deleteCinema(id);
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new CinemaValidator());
    }
}
