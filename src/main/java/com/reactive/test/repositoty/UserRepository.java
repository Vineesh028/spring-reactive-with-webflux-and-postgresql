package com.reactive.test.repositoty;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.test.entity.UserEntity;


@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {


}
