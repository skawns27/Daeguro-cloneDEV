package com.daeguro.client.vo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "userTB")
public class UserVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;
    @Column(unique = true, nullable = false)
    private String userEmail; //db테이블에 추가 필요

    private String userPw;  //db테이블에 추가 필요
    private String userTel;
    private String userBirth;
    private char userGender;
    private String userAddr;

    public UserVo( String userName,
                   String userEmail,
                   String userPw,
                   String userTel,
                   String userBirth,
                   char userGender,
                   String userAddr ) {

        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.userTel = userTel;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userAddr = userAddr;
    }

}
