package com.daeguro.client.service;


import com.daeguro.client.controller.userAcc.*;

import com.daeguro.client.protocol.UserAccProto;
import com.daeguro.lib.CodeType;
import com.daeguro.lib.MsgType;
import com.daeguro.client.dao.UserDao;
import com.daeguro.client.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.daeguro.lib.SessionConst.LOGINED;


public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {

        this.userDao = userDao;
    }

    @Transactional
    public UserAccRes01 userAcc01(UserVo newUser) {
        UserAccRes01 res = new UserAccRes01();
        try {
            checkDupUser(newUser);
            res.setUserId(userDao.save(newUser.getUserName(),
                    newUser.getUserEmail(),
                    newUser.getUserTel(),
                    newUser.getUserBirth(),
                    newUser.getUserGender(),
                    newUser.getUserAddr())); //반환 id

            res.setResCode(CodeType.OK);
            res.setResMsg(MsgType.OK);
        } catch(IllegalStateException e) {
            /*중복사용자 요청*/
            res.setResCode(CodeType.dupUser);
            res.setResMsg(MsgType.dupUser);
        } catch(Exception e) { // 기타오류 => 상황에 따라서 확장 생성예정
            /*기타오류 -> db or network error*/
            res.setResCode(CodeType.unKnownErr);
            res.setResMsg(MsgType.unKnownErr);
        }
        return res;
    }

    public UserAccRes02 userAcc02(String userEmail, String userPw) {
        UserAccRes02 res = new UserAccRes02();
        Optional<UserVo> findUser = userDao.findByEm(userEmail).stream().findAny();

        if(findUser.isEmpty()) {
            res.resCode = CodeType.noUserData;
            res.resMsg = MsgType.noUserData;
        } else if(userPw.equals(findUser.get().getUserPw())) {
            res.resCode = CodeType.wrongPw;
            res.resMsg = MsgType.wrongPw;
        } else {
            /*로그인 인증수단 추가 예정*/
            res.setResCode(CodeType.OK);
            res.setResMsg(MsgType.OK);
            res.setUserId(Optional.ofNullable(findUser.get().getUserId()));
        }
        return res;
    }
    
    public UserAccRes03 userAcc03(char loginState) {
        UserAccRes03 res = new UserAccRes03();

        if (loginState == LOGINED) {
            res.setResCode(CodeType.OK);
            res.setResMsg(MsgType.OK);
            return res;
        }
        res.setResCode(CodeType.unValidReq);
        res.setResMsg(MsgType.unValidReq);
        return res;
    }
    /*사용자 정보 조회
    * @param */
    public UserAccRes04 userAcc04(char userState, Long userId) {
        UserAccRes04 res = new UserAccRes04();

        if (userState == LOGINED) {
            res.setResCode(CodeType.OK);
            res.setResMsg(MsgType.OK);
            res.setUser(userDao.findById(userId));
        }
        return res;
    }
    /*사용자 정보 수정*/
    @Transactional
    public UserAccRes05 userAcc05(Long userId, char userState, UserAccReq05 updateUserData) {
        UserAccRes05 res = new UserAccRes05();

        if (userState == LOGINED) {
            try {
                userDao.updateProfile( userId,
                                        updateUserData.getUserName(),
                                        updateUserData.getUserTel(),
                                        updateUserData.getUserBirth(),
                                        updateUserData.getUserGender(),
                                        updateUserData.getUserAddr() );

                res.setResCode(CodeType.OK);
                res.setResMsg(MsgType.OK);

            } catch(Exception e) {
                res.setResCode(CodeType.unKnownErr);
                res.setResMsg(MsgType.unKnownErr);
            }
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
