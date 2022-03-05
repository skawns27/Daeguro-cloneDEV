package com.daeguro.client;

import com.daeguro.client.dao.StoreDao;
import com.daeguro.client.dao.UserDao;
import com.daeguro.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClientConfig {
    private final UserDao userDao;
    private StoreDao storeDao;



    public ClientConfig(UserDao userDao) {
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
