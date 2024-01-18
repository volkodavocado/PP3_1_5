package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AuthRestController {
    private final UserService service;
    private final RoleService roleService;

    public AuthRestController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("user")
    public ResponseEntity<User> getUserById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping("users")
    public ResponseEntity<User> addUser(User user) {
        service.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("users")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam Long id) {
        try {
            service.removeById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("edit")
    public ResponseEntity<User> updateUser(User user, @RequestParam Long id) {
        service.update(user, id);
        return ResponseEntity.ok(user);
    }
}
