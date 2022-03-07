package com.daeguro.client.controller.userAcc;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserAccReq01 {
    private String userName;
    private String userEmail; //db테이블에 추가 필요
    private String userPw;  //db테이블에 추가 필요
    private String userTel;
    private String userBirth;
    private char userGender;
    private String userAddr;

}
