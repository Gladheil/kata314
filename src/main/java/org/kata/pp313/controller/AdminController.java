//package org.kata.pp313.controller;
//
//import jakarta.validation.Valid;
//import org.kata.pp313.model.Role;
//import org.kata.pp313.model.User;
//import org.kata.pp313.service.RoleService;
//import org.kata.pp313.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashSet;
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Autowired
//    public AdminController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping("")
//    public String adminPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
//        model.addAttribute("newUser", new User());
//        return getAdminPage(userDetails, model);
//    }
//
////    @PostMapping("/add")
////    public String addUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult,
////                          @RequestParam(value = "roles", required = false) List<Integer> listRoleId,
////                          @AuthenticationPrincipal UserDetails userDetails,
////                          Model model) {
////        if (listRoleId == null || listRoleId.isEmpty()) {
////            bindingResult.rejectValue("roles", "error.newUser", "Choose a role");
////        }
////        if (userService.existsUserByEmail(user.getEmail())) {
////            bindingResult.rejectValue("email", "error.newUser", "This email already exists");
////        }
////        if (user.getAge() < 18) {
////            bindingResult.rejectValue("age", "error.newUser", "Age must be at least 18");
////        }
////        if (bindingResult.hasErrors()) {
////            System.out.println("binding results has errors");
////            model.addAttribute("bindingResult", bindingResult);
////            System.out.println(bindingResult.getAllErrors());
////            model.addAttribute("newUser", user);
////            model.addAttribute("activeTab", "new-user");
////            return getAdminPage(userDetails, model);
////        }
////        Lis t<Role> roles = roleService.getRolesByListId(listRoleId);
////        user.setRoles(new HashSet<>(roles));
////        userService.addUser(user);
////        return "redirect:/admin";
////    }
////
////    @PostMapping("/saveUserAfterUpdate")
////    public String saveUserAfterUpdate(@Valid User user, BindingResult bindingResult, Model model) {
////        if (user.getAge() < 18) {
////            bindingResult.rejectValue("age", "error.newUser", "Age must be at least 18");
////        }
////        if (bindingResult.hasErrors()) {
////            return "redirect:/admin";
////        }
////        try {
////            userService.updateUser(user);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return "redirect:/admin";
////    }
//
//    private String getAdminPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
//        String email = userDetails.getUsername();
//        User curUser = userService.getUserByEmail(email);
//        model.addAttribute("userRoles", curUser.getRoles());
//        model.addAttribute("userEmail", email);
//        model.addAttribute("allUsersList", userService.getAll());
//        model.addAttribute("roles", roleService.getRoles());
//        return "adminPage";
//    }
//}
//
////    @PostMapping("/deleteUser")
////    public String deleteUser(@RequestParam("id") int id) {
////        userService.deleteUserById(id);
////        return "redirect:/admin";
////    }
////
////}
//
////------------------------------------------------------------------------
//
////    @GetMapping("")
////    public String usersInfo(Model model) {
////        model.addAttribute("allUsersList", userService.getAll());
////        model.addAttribute("user", new User());
//////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//////        String username = authentication.getName();
//////        String roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).reduce((a,b) -> a + " " + b).orElse("");
//////        model.addAttribute("username", username);
//////        model.addAttribute("roles", roles);
////        return "adminPage";
////    }
////
////    @GetMapping("/formUser")
////    public String addUser(Model model) {
////        User user = new User();
////        model.addAttribute("user", user);
////        return "addUser";
////    }
////
////    @PostMapping("/addUser")
////    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
////        if (bindingResult.hasErrors()) {
////            return "addUser";
////        } else {
////            Role role = roleService.getRole("ROLE_USER");
////            user.addRole(role);
////            userService.addUser(user);
////            return "redirect:/admin";
////        }
////    }
////
////    @GetMapping("/deleteUser")
////    public String deleteUser(@ModelAttribute("id") Integer id) {
////        userService.deleteUserById(id);
////        return "redirect:/admin";
////    }
////
////    @GetMapping("/updateUser")
////    public String updateUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
////        model.addAttribute("user", userService.getUserById(id));
////        return "updateUser";
////    }
////
////    @PostMapping("/saveUserAfterUpdate")
////    public String saveUserAfterUpdate(@RequestParam("user") String roles,
////            @RequestParam("id") Integer id,
////            @RequestParam("firstName") String firstName,
////            @RequestParam("lastName") String lastName,
////            @RequestParam("age") Integer age,
////            @RequestParam("email") String email,
////            @RequestParam("password") String password,
////                                      BindingResult bindingResult) {
////        if (bindingResult.hasErrors()) {
////            return "updateUser";
////        } else {
////            User user = userService.getUserById(id);
////
////
////            Set<Role> userRoles = new HashSet<>(roleService.getRolesByNames(Arrays.asList(roles.split(","))));
////            user.setRoles(userRoles);
////            userService.updateUser(user);
////            return "redirect:/admin";
////        }
////    }
////
////
////}