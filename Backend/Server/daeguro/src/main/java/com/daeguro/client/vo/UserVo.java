package com.daeguro.client.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "userTB")
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="userid")
    private Long userId;
    @Column(name ="username")
    private String userName;
    @Column(name ="userem",unique = true, nullable = false)
    private String userEm; //db테이블에 추가 필요
    @Column(name ="userpw")
    private String userPw;  //db테이블에 추가 필요
    @Column(name ="usertel")
    private String userTel;
    @Column(name ="userbirth")
    private String userBirth;
    @Column(name ="usergender")
    private char userGender;
    @Column(name ="useraddr")
    private String userAddr;

}
