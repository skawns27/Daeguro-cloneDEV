package com.daeguro.common.vo;

import javax.persistence.*;

@Entity
@Table(schema = "userTB")
public class UserVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String userName;
    @Column(unique = true, nullable = false)
    private String userEmail; //db테이블에 추가 필요

    private String userPw;  //db테이블에 추가 필요
    private String userTel;
    private String userBirth;
    private char userGender;
    private String userAddr;

    public UserVo(String userName, String userEmail, String userPw, String userTel, String userBirth, char userGender, String userAddr) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.userTel = userTel;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userAddr = userAddr;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPw() {
        return userPw;
    }

    public String getUserTel() {
        return userTel;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public char getUserGender() {
        return userGender;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public long getUserId() {
        return userId;
    }
}
