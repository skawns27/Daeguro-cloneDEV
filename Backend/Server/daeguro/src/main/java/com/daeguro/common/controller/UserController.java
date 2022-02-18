package com.daeguro.common.controller;

import com.daeguro.common.controller.userAcc.UserAccReq01;
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

    @PostMapping("users/new")
    public long regUser(@RequestBody UserAccReq01 userAccReq01 ) {
        UserVo userVo = new UserVo(userAccReq01.getUserName(),
                                    userAccReq01.getUserEmail(),
                                    userAccReq01.getUserPw(),
                                    userAccReq01.getUserTel(),
                                    userAccReq01.getUserBirth(),
                                    userAccReq01.getUserGender(),
                                    userAccReq01.getUserAddr());

        return userService.userAcc01(userVo);
    }
}
