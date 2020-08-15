package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yuriismac on 2020-08-13.
 * @project demo
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
