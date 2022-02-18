package com.daeguro.common.service;

import com.daeguro.common.dao.UserDao;
import com.daeguro.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;


public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public long userAcc01(UserVo newUser) {
        checkDupUser(newUser);
        userDao.save(newUser);
        return newUser.getUserId();
    }

    public long userAcc02(String userEm, String userPw) {

    }

    private void checkDupUser(UserVo checkUser) {
        userDao.findByEm(checkUser.getUserEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원정보");
                });
    }

}
