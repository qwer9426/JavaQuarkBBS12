package com.quark.chat.service.impl;

import com.quark.chat.service.ChatService;
import com.quark.chat.service.RedisService;
import com.quark.common.base.BaseServiceImpl;
import com.quark.common.dao.UserDao;
import com.quark.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ChatServiceImpl extends BaseServiceImpl<UserDao,User> implements ChatService{

    @Autowired
    private RedisService<User> redisService;

    @Value("${REDIS_USER_KEY}")
    private String REDIS_USER_KEY;


    @Override
    public User getUserByToken(String token) {
        User user = redisService.getString(REDIS_USER_KEY + token);
        return user;
    }

    @Override
    public boolean authUser(Integer id) {
        /**
         * 注意这里的原方法是getone但是新版jpa会进行懒加载，所以进行了修改
         */
        Optional<User> user = repository.findById(id);
        return user.get().getEnable() == 1;
    }


}
