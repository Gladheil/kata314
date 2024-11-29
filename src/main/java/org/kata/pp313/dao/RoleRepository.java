package org.kata.pp313.dao;

import org.kata.pp313.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
