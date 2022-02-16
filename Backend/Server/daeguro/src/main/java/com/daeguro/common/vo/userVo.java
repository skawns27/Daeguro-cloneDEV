package com.daeguro.common.vo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "userTB")
public class userVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String userName;
    @Column(unique = true, nullable = false)
    private String userEmail; //db테이블에 추가 필요

    private String userPw;  //db테이블에 추가 필요
    private String userTel;
    private Date userBirth;
    private char userGender;
    private String userAddr;

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

    public void setUserBirth(Date userBirth) {
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

    public Date getUserBirth() {
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
