package com.example.demo.dto;

import com.example.demo.model.Cinema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuriismac on 2020-07-30.
 * @project demo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CinemaDTO {

    private List<Cinema> cinemas;
    private int totalElements;
    private int totalCount;
    private boolean isLast;
    private boolean isEmpty;
}
