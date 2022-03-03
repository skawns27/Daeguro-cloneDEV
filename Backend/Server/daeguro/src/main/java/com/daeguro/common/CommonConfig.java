package com.daeguro.common;

import com.daeguro.common.controller.dao.StoreDao;
import com.daeguro.common.controller.dao.UserDao;
import com.daeguro.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CommonConfig {
    private UserDao userDao;
    private StoreDao storeDao;


    @Autowired
    public CommonConfig(UserDao userDao) {
        this.userDao = userDao;
    }

    @Bean
    public UserService userService() {
        return new UserService(userDao);
    }

//    @Bean
//    public UserDao userDao() {
//        return new MysqlUserDao();
//    }

   /* @Bean
    public StoreDao storeDao() {
        return new MyqslStoreDao(em);
    }*/
}
