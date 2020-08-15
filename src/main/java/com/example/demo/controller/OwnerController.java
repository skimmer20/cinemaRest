package com.example.demo.controller;

import com.example.demo.model.Owner;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuriismac on 2020-07-19.
 * @project demo
 */
@RestController
@RequestMapping(path = "/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> owners(){
        return ownerService.getAllOwners();
    }
    @PostMapping
    public Owner createOwner(@RequestBody Owner owner){
        return ownerService.insertOwner(owner);
    }
}
