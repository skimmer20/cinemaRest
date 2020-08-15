package com.example.demo.model;

import com.example.demo.validation.UniqueCinemaTitle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * @author yuriismac on 2020-07-06.
 * @project demo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @NotBlank
    @UniqueCinemaTitle
    private String title;
    @NotBlank
    private String description;
    @Positive
    private int roomQuantity;

    @ManyToOne(targetEntity = Owner.class, optional = false, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Owner owner;
}
