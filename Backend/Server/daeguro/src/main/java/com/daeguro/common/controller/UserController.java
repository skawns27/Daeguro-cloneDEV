package com.daeguro.common.controller;

import com.daeguro.common.controller.userAcc.*;
import com.daeguro.common.service.UserService;
import com.daeguro.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

        UserVo userVo = new UserVo(userAccReq01.getUserName(),
                                    userAccReq01.getUserEmail(),
                                    userAccReq01.getUserPw(),
                                    userAccReq01.getUserTel(),
                                    userAccReq01.getUserBirth(),
                                    userAccReq01.getUserGender(),
                                    userAccReq01.getUserAddr());
        return userService.userAcc01(userVo); // =>회원가입 서비스 결과(resCode, resMsg) 리턴
    }
    /*사용자 로그인 요청*/
    @PostMapping("users/login")
    public UserAccRes02 loginUser(@RequestBody UserAccReq02 userAccReq02) {

        return userService.userAcc02(userAccReq02.getUserEmail(), userAccReq02.getUserPw());
    }

    /*사용자 로그아웃 TODO*/
//    @PostMapping("user/logout")
//    public UserAccRes03 logoutUser(@RequestBody UserAccReq03 userAccReq03) {
//
//        return userService.userAcc03(userAccReq03.getUserId());
//    }

}
