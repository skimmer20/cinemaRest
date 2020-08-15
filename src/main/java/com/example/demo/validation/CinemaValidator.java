package com.example.demo.validation;

import com.example.demo.model.Cinema;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author yuriismac on 2020-07-13.
 * @project demo
 */
@Component
public class CinemaValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Cinema.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Cinema cinema = (Cinema) object;
        if (!StringHelper.isNullOrEmptyString(cinema.getTitle())) {
            char firstLetter = cinema.getTitle().charAt(0);
            if (firstLetter < 65 || 90 < firstLetter) {
                errors.rejectValue("title", "cinema.title.capital-letter");
            }
        }
    }
}
