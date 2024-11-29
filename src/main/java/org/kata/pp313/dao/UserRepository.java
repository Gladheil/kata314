package org.kata.pp313.dao;

import org.kata.pp313.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByFirstName(String name);
    UserDetails findByEmail(String email);
}
