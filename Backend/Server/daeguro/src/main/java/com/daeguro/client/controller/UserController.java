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
import java.io.IOException;
import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    /*사용자 회원가입 요청*/
    @PostMapping("users/new")
    @ResponseBody
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
    @PostMapping("/login")
    @ResponseBody
    public UserAccRes02 loginUser(@RequestBody UserAccReq02 userAccReq02,
                                  @RequestParam(defaultValue = "/login") String redirectURL,
                                  HttpServletRequest httpReq,
                                  HttpServletResponse httpRes) {
        /*세션유무 확인*/
        /*사용자 정보 조회*/
        UserAccRes02 res = userService
                            .userAcc02(userAccReq02.getUserEmail(),
                                        userAccReq02.getUserPw());
        Optional<Long> loginUser = res.getUserId();

        if (loginUser.isEmpty()) {
            return res;
        }
        /*세션생성 -> 사용자 COOKIE 에 세션 ID 첨부까지*/
        HttpSession session = httpReq.getSession(false); //중복 로그인 확인

        if (session.getAttribute(SessionConst.LOGIN_USER) != null) {
            session.invalidate();
            session = httpReq.getSession(); //새 세션할당
            res.setResCode('9');
        }

        session.setAttribute(SessionConst.LOGIN_USER, loginUser);

        try {
            httpRes.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /*사용자 로그아웃*/
    @PostMapping("user/logout")
    @ResponseBody
    public UserAccRes03 logoutUser(@RequestBody UserAccReq03 userAccReq03,
                                   HttpServletRequest httpReq,
                                   HttpServletResponse httpRes) {

        HttpSession session = httpReq.getSession(false);

        if (session.getAttribute(SessionConst.LOGIN_USER) != null) {
            session.invalidate();
        }

        try {
            httpRes.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

       return userService.userAcc03();
    }
    /*사용자정보 조회*/
    @GetMapping("user/my/{userId}")
    @ResponseBody
    public UserAccRes04 findUser(@PathVariable String userId,
                                 HttpServletRequest httpReq,
                                 HttpServletResponse httpRes) {

        HttpSession session = httpReq.getSession(false);
        Long sessionUserId = Long.parseLong(session.getAttribute(SessionConst.LOGIN_USER).toString());
        try {
            httpRes.sendRedirect("user/my");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userService.userAcc04(Long.parseLong(userId),sessionUserId);
    }
    /*사용자정보 프로필정보 수정*/
    @ResponseBody
    @PostMapping("user/my/{userId}/update")
    public UserAccRes05 updateUser(@PathVariable String userId,
                                   @RequestBody UserAccReq05 updateUserData,
                                   HttpServletRequest httpReq,
                                   HttpServletResponse httpRes) {

        UserAccRes05 res;
        HttpSession session = httpReq.getSession(false);
        Long sessionUserId = Long.parseLong(session.getAttribute(SessionConst.LOGIN_USER).toString());
        res = userService.userAcc05(Long.parseLong(userId), sessionUserId, updateUserData);

        if(res.getResCode() == CodeType.OK) {
            /*세션 초기화*/
            session.invalidate();
            httpReq.getSession();
        }

        try {
            httpRes.sendRedirect("user/my");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

}
