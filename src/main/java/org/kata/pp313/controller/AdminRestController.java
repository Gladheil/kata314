package org.kata.pp313.controller;

import org.apache.coyote.Response;
import org.kata.pp313.model.Role;
import org.kata.pp313.model.User;
import org.kata.pp313.service.RoleService;
import org.kata.pp313.service.RoleServiceImpl;
import org.kata.pp313.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/user")
    public Map<String, Object> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return Map.of(
                "userEmail", userDetails.getUsername(),
                "userRoles", userDetails.getAuthorities().stream().map(role -> role.getAuthority().replace("ROLE_", " "))
        );
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        System.out.println("-------------------------PUT---------------------------");
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        System.out.println("--------------------------Deleting");
        userService.deleteUserById(id);
        System.out.println("--------------------------Delete complete");
        return ResponseEntity.noContent().build();
    }
}
