package com.daeguro.common.controller;

import com.daeguro.common.controller.userAcc.UserAccReq01;
import com.daeguro.common.controller.userAcc.UserAccReq02;
import com.daeguro.common.controller.userAcc.UserAccRes01;
import com.daeguro.common.controller.userAcc.UserAccRes02;
import com.daeguro.common.service.UserService;
import com.daeguro.common.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    /*사용자 회원가입 요청 req*/
    @PostMapping("users/new")
    public UserAccRes01 regUser(@RequestBody UserAccReq01 userAccReq01) { // UserAccReq01 => 회원가입 요청 포멧
        UserAccRes01 res = new UserAccRes01();
        UserVo userVo = new UserVo(userAccReq01.getUserName(),
                                    userAccReq01.getUserEmail(),
                                    userAccReq01.getUserPw(),
                                    userAccReq01.getUserTel(),
                                    userAccReq01.getUserBirth(),
                                    userAccReq01.getUserGender(),
                                    userAccReq01.getUserAddr());
        return userService.userAcc01(userVo); // =>회원가입 서비스 결과 return
    }

    @PostMapping("users/login")
    public long loginUser(@RequestBody UserAccReq02 userAccReq02) {

//        return userService.userAcc02(userAccReq02.getUserEmail(), userAccReq02.getUserPw());
        return 0;
    }
}
