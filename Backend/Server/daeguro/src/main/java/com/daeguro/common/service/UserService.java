package com.daeguro.common.service;

import com.daeguro.common.CodeType;
import com.daeguro.common.MsgType;
import com.daeguro.common.controller.dao.UserDao;
import com.daeguro.common.controller.userAcc.UserAccRes01;
import com.daeguro.common.controller.userAcc.UserAccRes02;
import com.daeguro.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;


public class UserService {
    private UserDao userDao;
    private MsgType msgType = new MsgType();
    private CodeType codeType = new CodeType();

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
            res.resCode = codeType.OK;
            res.resMsg = msgType.OK;
        } catch(IllegalStateException e) {
            /*중복사용자 요청*/
            res.resCode = codeType.dupUser;
            res.resMsg = msgType.dupUser;
        } catch(Exception e) { // 기타오류 => 상황에 따라서 확장 생성예정
            /*기타오류 -> db or network error*/
            res.resCode = codeType.unKnownErr;
            res.resMsg = msgType.unKnownErr;
        } finally {
            return res;
        }
    }

    public UserAccRes02 userAcc02(String userEmail, String userPw) {
        UserAccRes02 res = new UserAccRes02();
        Optional<UserVo> findUser = userDao.findByEm(userEmail).stream().findAny();

        if(findUser.isEmpty()) {
            res.resCode = codeType.noUserData;
            res.resMsg = msgType.noUserData;
        } else if(userPw != findUser.get().getUserPw()) {
            res.resCode = codeType.wrongPw;
            res.resMsg = msgType.wrongPw;
        } else {
            /*로그인 인증수단 추가 예정*/
            res.resCode = codeType.OK;
            res.resMsg = msgType.OK;
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
