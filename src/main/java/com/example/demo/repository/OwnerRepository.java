package com.example.demo.repository;

import com.example.demo.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuriismac on 2020-07-19.
 * @project demo
 */
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
