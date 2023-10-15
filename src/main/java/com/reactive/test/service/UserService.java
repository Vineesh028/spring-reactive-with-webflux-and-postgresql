package com.reactive.test.service;


import com.reactive.test.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> create(Mono<User> user);

    Mono<User> retrieve(int userId);

    Mono<User> update(int userId, Mono<User> user);

    Mono<Void> delete(int userId);

    Flux<User> list();
}
