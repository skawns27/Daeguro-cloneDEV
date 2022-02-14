package com.daeguro.order.vo;

import java.util.Date;

public class userVo {
    private long userId;
    private String userName;
    private String userEmail; //db테이블에 추가 필요
    private String userPw;  //db테이블에 추가 필요
    private String userTel;
    private Date userBirth;
    private char userGender;
    private String userAddr;

    public order
    public userJoin(String userName,
                    String userEmail,
                    String userPw,
                    String userTel,
                    Date userBirth,
                    char userGender,
                    String userAddr) {

        /*email, 전화번호 중복 예제 추가예정*/
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw; // 비밀번호는 암호화된 상태로 저장
        this.userTel = userTel;
        this.userBirth = userBirth;
        this.userGender = userGender;
    }
}
