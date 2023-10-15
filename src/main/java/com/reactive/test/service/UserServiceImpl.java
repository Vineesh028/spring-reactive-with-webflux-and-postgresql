/**
 * 
 */
package com.reactive.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.test.model.User;
import com.reactive.test.repositoty.UserRepository;
import com.reactive.test.util.UserUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Mono<User> create(Mono<User> user) {
        return user.map(UserUtils::toUserEntity).flatMap(userRepository::save).map(UserUtils::toUser);
    }

    @Override
    public Mono<User> retrieve(int userId) {
        return userRepository.findById(userId).map(UserUtils::toUser);
    }

    @Override
    public Mono<User> update(int userId, Mono<User> user) {
        return userRepository.findById(userId)
                .flatMap(userEntity -> user
                        .map(UserUtils::toUserEntity)
                        .doOnNext(u -> u.setId(userId)))
                .flatMap(userRepository::save).map(UserUtils::toUser);
    }

    @Override
    public Mono<Void> delete(int userId) {
        return userRepository.deleteById(userId);
    }

    @Override
    public Flux<User> list() {
        return userRepository.findAll().map(UserUtils::toUser);
    }
}