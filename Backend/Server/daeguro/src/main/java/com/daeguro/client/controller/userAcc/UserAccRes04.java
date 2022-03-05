package com.daeguro.client.controller.userAcc;

import com.daeguro.client.vo.UserVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
public class UserAccRes04 {
    private char resCode;
    private String resMsg;
    private UserVo user;

    public void getUser(Optional<UserVo> user) {
        this.user = user.get();
    }
}
