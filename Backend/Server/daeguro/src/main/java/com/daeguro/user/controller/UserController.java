package com.daeguro.user.controller;

import com.daeguro.user.service.UserService;
import com.daeguro.user.vo.UserVO;
import com.daeguro.lib.CodeType;
import com.daeguro.lib.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    /*사용자 회원가입 요청*/
    @PostMapping("/users/new")
    @ResponseBody
    public HashMap<String, Object> regUser(@RequestBody UserVO reqLoginUser) {

        UserVO userVO = new UserVO();
        userVO.setUserName(reqLoginUser.getUserName());
        userVO.setUserEm(reqLoginUser.getUserEm());
        userVO.setUserPw(reqLoginUser.getUserPw());
        userVO.setUserTel(reqLoginUser.getUserTel());
        userVO.setUserBirth(reqLoginUser.getUserBirth());
        userVO.setUserGender(reqLoginUser.getUserGender());
        userVO.setUserAddr(reqLoginUser.getUserAddr());

        HashMap<String, Object> res = userService.userAcc01(userVO);
        return res; // =>회원가입 서비스 결과(resCode, resMsg) 리턴
    }
    /*사용자 로그인 요청*/
    @PostMapping("/user/login")
    @ResponseBody
    public HashMap<String, Object> loginUser(@RequestBody UserVO userVO,
                                  @RequestParam(defaultValue = "/user/login") String redirectURL,
                                  HttpServletRequest httpReq,
                                  HttpServletResponse httpRes) {
        /*세션유무 확인*/
        userVO.setUserState(SessionConst.NORMAL_LOGIN);
        HttpSession session = httpReq.getSession(false); //중복 로그인 확인

        if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
            session = httpReq.getSession(); // 세션 생성
            log.info("로그인 => 새로운 세션생성");
        } else {
            log.info("중복 로그인 => 세션 초기화");
            session.invalidate(); // 세션 초기화
            session = httpReq.getSession(); //새 세션할당
            userVO.setUserState(SessionConst.DUP_LOGIN);
        }
        /*사용자 정보 조회*/
        // 세션ID 인증 코드 추가예정
        /*if (userId != sessionUserId) {
            res.setResCode(CodeType.unValidReq);
            res.setResMsg(MsgType.unValidReq);

            return res;
        }*/
        HashMap<String, Object> res = userService.userAcc02(userVO);
        session.setAttribute(SessionConst.LOGIN_USER, userVO.getUserId());//사용자 id 속성 추가

        //redirect 기능 추가예정
       /* try {
            httpRes.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return res;
    }

    /*사용자 로그아웃*/
    @PostMapping("/user/logout")
    @ResponseBody
    public HashMap<String, Object> logoutUser(HttpServletRequest httpReq,
                                   HttpServletResponse httpRes) {

        HashMap<String, Object> res;
        HttpSession session = httpReq.getSession(false);
        if (session.getAttribute(SessionConst.LOGIN_USER) != null) {
            session.invalidate();
        }

        try {
            httpRes.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        res = userService.userAcc03();
       return res;
    }
    /*사용자정보 조회*/
    @GetMapping("/user/my")
    @ResponseBody
    public HashMap<String, Object> findUser(HttpServletRequest httpReq) {

        HttpSession session = httpReq.getSession(false);
        Long sessionUserId = Long.parseLong(session.getAttribute(SessionConst.LOGIN_USER).toString());

        return userService.userAcc04(sessionUserId);
    }

    /*사용자정보 프로필정보 수정*/
    @ResponseBody
    @PostMapping("user/my/{userId}/update")
    public HashMap<String, Object> updateUser(@PathVariable String userId,
                                   @RequestBody UserVO userVO,
                                   HttpServletRequest httpReq,
                                   HttpServletResponse httpRes) {

        HashMap<String, Object> res;
        HttpSession session = httpReq.getSession(false);
        Long sessionUserId = Long.parseLong(session.getAttribute(SessionConst.LOGIN_USER).toString());
        log.info("sessionUserId = {}", sessionUserId);
        res = userService.userAcc05(userVO);

        if(res.get("resCode") == CodeType.OK) {
            /*세션 초기화*/
            session.invalidate();
            httpReq.getSession();
        }
        //내 정보 화면으로 redirect
        try {
            httpRes.sendRedirect("user/my");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

}
