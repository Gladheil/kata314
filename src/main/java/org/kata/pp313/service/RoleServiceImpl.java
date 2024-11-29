package org.kata.pp313.service;

import org.kata.pp313.dao.RoleRepository;
import org.kata.pp313.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public List<Role> getRolesByNames(List<String> names) {
        return List.of();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> getRolesByListId(List<Integer> listId) {
        return roleRepository.findAllById(listId);
    }
}
