package com.reactive.test.util;

import org.modelmapper.ModelMapper;

import com.reactive.test.entity.UserEntity;
import com.reactive.test.model.User;

public class UserUtils {
	
    
    private static ModelMapper mapper = new ModelMapper();
	
    public static UserEntity toUserEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }

    public static User toUser(UserEntity userEntity) {
        return mapper.map(userEntity, User.class);
    }
}