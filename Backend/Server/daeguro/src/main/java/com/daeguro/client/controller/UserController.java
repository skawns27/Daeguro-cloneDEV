package com.daeguro.client.controller;

import com.daeguro.client.controller.userAcc.*;
import com.daeguro.client.service.UserService;
import com.daeguro.client.vo.UserVo;
import com.daeguro.lib.CodeType;
import com.daeguro.lib.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.daeguro.lib.SessionConst.LOGINED;
import static com.daeguro.lib.SessionConst.NOT_LOGINED;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    /*사용자 회원가입 요청*/
    @PostMapping("users/new")
    public UserAccRes01 regUser(@RequestBody UserAccReq01 userAccReq01) {

        UserVo userVo = new UserVo();
        userVo.setUserName(userAccReq01.getUserName());
        userVo.setUserEm(userAccReq01.getUserEm());
        userVo.setUserPw(userAccReq01.getUserPw());
        userVo.setUserTel(userAccReq01.getUserTel());
        userVo.setUserBirth(userAccReq01.getUserBirth());
        userVo.setUserGender(userAccReq01.getUserGender());
        userVo.setUserAddr(userAccReq01.getUserAddr());
        return userService.userAcc01(userVo); // =>회원가입 서비스 결과(resCode, resMsg) 리턴
    }
    /*사용자 로그인 요청*/
   /* @PostMapping("users/login")
    public UserAccRes02 loginUser(@RequestBody UserAccReq02 userAccReq02,
                                  HttpServletRequest req) {

        UserAccRes02 res = userService
                            .userAcc02(userAccReq02.getUserEmail(),
                                        userAccReq02.getUserPw());

        Optional<Long> loginUser = res.getUserId();

        if (loginUser.isEmpty()) {
            return res;
            *//*결과값 전달*//*
        }
        *//*세션생성 -> 사용자 COOKIE 에 세션ID 첨부까지*//*
        HttpSession session = req.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        return res;
    }

    *//*사용자 로그아웃*//*
    @PostMapping("user/logout")
    public UserAccRes03 logoutUser(@RequestBody UserAccReq03 userAccReq03,
                                   HttpServletRequest req) {
        char userState = NOT_LOGINED;
        HttpSession session = req.getSession(false);
        if (session != null) {
            userState = LOGINED;
            session.invalidate();
        }
        return userService.userAcc03(userState);
    }
    *//*사용자정보 조회*//*
    @GetMapping("user/my/{userId}")
    public UserAccRes04 findUser(@PathVariable String userId,
                                 HttpServletRequest req) {
        char userState = NOT_LOGINED;
        HttpSession session = req.getSession(false);
        if (session != null) {
            *//*접근허용 사용자*//*
            userState = LOGINED;
        }
        return userService.userAcc04(userState, Long.parseLong(userId));
    }
    *//*사용자정보 프로필정보 수정*//*
    @ResponseBody
    @PostMapping("user/my/{userId}/update")
    public UserAccRes05 updateUser(@PathVariable String userId,
                                   @RequestBody UserAccReq05 updateUserData,
                                   HttpServletRequest req) {

        char userState = NOT_LOGINED;
        UserAccRes05 res;
        HttpSession session = req.getSession(false);

        if (session != null) {
            *//*접근허용 사용자*//*
            userState = LOGINED;
        }

        res = userService.userAcc05(Long.parseLong(userId), userState, updateUserData);

        if(res.getResCode() == CodeType.OK) {
            *//*세션 초기화*//*
            session.invalidate();
            req.getSession();
        }

        return res;
    }*/

}
