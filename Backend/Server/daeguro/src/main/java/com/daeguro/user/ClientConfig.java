package com.daeguro.user;

import com.daeguro.user.dao.StoreDao;
import com.daeguro.user.dao.UserDao;
import com.daeguro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClientConfig {
    private final UserDao userDao;
    private StoreDao storeDao;


    @Autowired
    public ClientConfig(UserDao userDao) {
        this.userDao = userDao;
    }

    @Bean
    public UserService userService() {
        return new UserService(userDao);
    }


   /* @Bean
    public StoreDao storeDao() {
        return new MyqslStoreDao(em);
    }*/
}
