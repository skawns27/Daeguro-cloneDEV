package com.daeguro.user.service;

import com.daeguro.lib.CodeType;
import com.daeguro.lib.MsgType;
import com.daeguro.user.dao.UserDao;
import com.daeguro.user.vo.UserVO;
import com.daeguro.lib.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {

        this.userDao = userDao;
    }

    /**
     * @param userVO:사용자 이메일
     * @return res: 결과 메시지, 결과 코드
     * @brief 회원가입 함수
     * @date 2022-05-19
     */
    /*회원가입*/
    public HashMap<String, Object> userAcc01(UserVO userVO) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            checkDupUser(userVO);
            userDao.save(userVO);

            res.put("userId", (userDao.save(userVO).getUserId()).toString()); //반환 id`
            res.put("resCode", CodeType.OK);
            res.put("resMsg", MsgType.OK);

        } catch (IllegalStateException e) {
            /*중복사용자 요청*/
            res.put("resCode", CodeType.dupUser);
            res.put("resMsg", MsgType.dupUser);

        } catch (Exception e) { // 기타오류 => 상황에 따라서 확장 생성예정
            /*기타오류 -> db or network error*/
            res.put("resCode", CodeType.unKnownErr);
            res.put("resMsg", MsgType.unKnownErr);
            log.debug("DB Exception = {}", e);
        }
        return res;
    }

    /**
     * @param userVO:사용자 이메일 + 사용자 비밀번호
     * @return ResProtocol
     * @brief 로그인 함수
     * @date 2022-05-18
     */
    public HashMap<String, Object> userAcc02(UserVO userVO) {
        HashMap<String, Object> res;
        Optional<UserVO> findUserVO = userDao.findByUserEm(userVO.getUserEm()).stream().findAny();
        /*중복 로그인 세션 검증 절차 추가예정*/
        log.info("사용자 로그인 상태:{}", userVO.getUserState());
        res = checkLoginValidate(userVO, findUserVO);
        log.info("로그인 결과값 ={}", res);
        return res;
    }

    public HashMap<String, Object> userAcc03() {
        HashMap<String, Object> res = new  HashMap<String, Object>();

        res.put("resCode", CodeType.unValidReq);
        res.put("resMsg", MsgType.unValidReq);

        return res;
    }

    /*사용자 정보 조회*/
    public HashMap<String, Object> userAcc04(Long userId) {
        HashMap<String, Object> res = new  HashMap<String, Object>();


        res.put("resCode", CodeType.OK);
        res.put("resMsg", MsgType.OK);
        res.put("userVO", userDao.findById(userId));

        return res;
    }

    /*사용자 정보 수정*/
    public HashMap<String, Object> userAcc05(UserVO userVO) {
        HashMap<String, Object> res = new HashMap<>();
        /*정보 수정(시작)*/
        try {
            userDao.updateProfile(
                    userVO.getUserId(),
                    userVO.getUserName(),
                    userVO.getUserTel(),
                    userVO.getUserBirth(),
                    userVO.getUserGender(),
                    userVO.getUserAddr());

            res.put("userId", userVO.getUserId());
            res.put("resCode", CodeType.OK);
            res.put("resMsg", MsgType.OK);

        } catch (Exception e) {
            res.put("resCode", CodeType.unKnownErr);
            res.put("resMsg", MsgType.unKnownErr);
        }
        return res;
    }

    /*중복 사용자 검증*/
    private void checkDupUser(UserVO checkUserInfo) {
        userDao.findByUserEm(checkUserInfo.getUserEm())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원정보");
                });
    }
    private HashMap<String, Object> checkLoginValidate(UserVO userVO, Optional<UserVO> findUserVO) {
        HashMap<String, Object> res = new HashMap<>();
        if (findUserVO.isEmpty()) { //없는 사용자 정보

            res.put("resCode", CodeType.noUserData);
            res.put("resMsg", MsgType.noUserData);

        } else if (findUserVO.get().getUserPw().equals(userVO.getUserPw())) {
            /*잘못된 비밀번호 */
            res.put("resCode", CodeType.wrongPw);
            res.put("resMsg", MsgType.wrongPw);

        } else {
            /*로그인 인증수단 추가 예정*/
            switch (userVO.getUserState()) {
                case SessionConst.NORMAL_LOGIN: {
                    res.put("resCode",CodeType.OK);
                    res.put("resMsg",MsgType.OK);
                }
                break;
                case SessionConst.DUP_LOGIN: {
                    res.put("resCode", CodeType.DupLogin);
                    res.put("resMsg", MsgType.DupLogin);
                }
                break;
            }
        }
        return res;
    }
}
