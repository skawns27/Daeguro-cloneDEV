package com.daeguro.client.controller.userAcc;

import com.daeguro.client.vo.UserVo;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserAccReq05 {
    private Long userId;
    private String userName;
    private String userTel;
    private String userBirth;
    private char userGender;
    private String userAddr;
}
