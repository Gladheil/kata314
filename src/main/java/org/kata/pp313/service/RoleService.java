package org.kata.pp313.service;

import org.kata.pp313.model.Role;

import java.util.List;

public interface RoleService {
    Role getRole(String roleName);
    void addRole(Role role);
    List<Role> getRolesByNames(List<String> names);
    List<Role> getRoles();
    List<Role> getRolesByListId(List<Integer> listId);
}
