package org.kata.pp313.controller;

import org.kata.pp313.model.User;
import org.kata.pp313.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        return Map.of(
                "userEmail", userDetails.getUsername(),
                "userRoles", userDetails.getAuthorities().stream().map(role -> role.getAuthority().replace("ROLE_", " "))
        );
    }

    @GetMapping("/user")
    public User getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getUserByEmail(userDetails.getUsername());
    }
}
