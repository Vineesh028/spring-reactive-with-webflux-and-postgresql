package com.reactive.test.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.test.model.User;
import com.reactive.test.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    Mono<User> create(@RequestBody Mono<User> userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/{userId}")
    Mono<ResponseEntity<User>> retrieve(@PathVariable int userId) {
        return userService.retrieve(userId)
                .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    Mono<ResponseEntity<User>> update(@PathVariable int userId, @RequestBody Mono<User> userDto) {
        return userService.update(userId, userDto).map(ResponseEntity::ok).defaultIfEmpty(
                ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{userId}")
    Mono<Void> delete(@PathVariable int userId) {
        return userService.delete(userId);
    }

    @GetMapping("/")
    Flux<User> list() {
        return userService.list();
    }
}