package com.daeguro.client.service;

import com.daeguro.lib.CodeType;
import com.daeguro.lib.MsgType;
import com.daeguro.client.controller.dao.UserDao;
import com.daeguro.client.controller.userAcc.UserAccRes01;
import com.daeguro.client.controller.userAcc.UserAccRes02;
import com.daeguro.client.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;


public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public UserAccRes01 userAcc01(UserVo newUser) {
        UserAccRes01 res = new UserAccRes01();
        try {
            checkDupUser(newUser);
            userDao.save(newUser);
            res.resCode = CodeType.OK;
            res.resMsg = MsgType.OK;
        } catch(IllegalStateException e) {
            /*중복사용자 요청*/
            res.resCode = CodeType.dupUser;
            res.resMsg = MsgType.dupUser;
        } catch(Exception e) { // 기타오류 => 상황에 따라서 확장 생성예정
            /*기타오류 -> db or network error*/
            res.resCode = CodeType.unKnownErr;
            res.resMsg = MsgType.unKnownErr;
        } finally {
            return res;
        }
    }

    public UserAccRes02 userAcc02(String userEmail, String userPw) {
        UserAccRes02 res = new UserAccRes02();
        Optional<UserVo> findUser = userDao.findByEm(userEmail).stream().findAny();

        if(findUser.isEmpty()) {
            res.resCode = CodeType.noUserData;
            res.resMsg = MsgType.noUserData;
        } else if(userPw != findUser.get().getUserPw()) {
            res.resCode = CodeType.wrongPw;
            res.resMsg = MsgType.wrongPw;
        } else {
            /*로그인 인증수단 추가 예정*/
            res.resCode = CodeType.OK;
            res.resMsg = MsgType.OK;
            res.userId = findUser.get().getUserId();
            res.userName = findUser.get().getUserName();
            res.userAddr = findUser.get().getUserAddr();
        }
        return res;
    }


    private void checkDupUser(UserVo checkUser) {
        userDao.findByEm(checkUser.getUserEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원정보");
                });
    }


}
