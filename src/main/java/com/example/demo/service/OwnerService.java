package com.example.demo.service;

import com.example.demo.model.Owner;

import java.util.List;

/**
 * @author yuriismac on 2020-07-19.
 * @project demo
 */
public interface OwnerService {
    Owner insertOwner(Owner owner);
    List<Owner> getAllOwners();
}
