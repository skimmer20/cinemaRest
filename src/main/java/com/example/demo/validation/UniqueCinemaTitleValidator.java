package com.example.demo.validation;

import com.example.demo.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yuriismac on 2020-07-15.
 * @project demo
 */
public class UniqueCinemaTitleValidator implements ConstraintValidator<UniqueCinemaTitle, String > {


    @Autowired
    CinemaRepository cinemaRepository;
    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return true; //change
    }
}
