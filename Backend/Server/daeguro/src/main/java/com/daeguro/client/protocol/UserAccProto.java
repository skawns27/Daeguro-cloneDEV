package com.daeguro.client.protocol;

import com.daeguro.client.vo.UserVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class UserAccProto {

    @Getter @Setter
    public class UserAccReq01 {
        private long userId;
        private String userName;
        private String userEmail; //db테이블에 추가 필요
        private String userPw;  //db테이블에 추가 필요
        private String userTel;
        private String userBirth;
        private char userGender;
        private String userAddr;

    }

    @Getter @Setter
    public class UserAccReq02 {
        private String userEmail;
        private String userPw;
    }

    @Getter @Setter
    public class UserAccReq03 {
        private Long userId;
    }

    @Getter @Setter
    public class UserAccReq04 {
        private Long userId;

    }

    @Getter @Setter
    public class UserAccReq05 {
        private Long userId;
        private String userName;
        private String userTel;
        private String userBirth;
        private String userGender;
        private String userAddr;
    }

    @Getter @Setter
    public static class UserAccRes01 {
        private char resCode;
        private String resMsg;
        private Optional<Long> userId;
    }

    @Getter @Setter
    public class UserAccRes02 {
        public char resCode;
        public String resMsg;
        private Optional<Long> userId;
    }

    @Getter @Setter
    public class UserAccRes03 {
        private char resCode;
        private String resMsg;
    }

    @Getter @Setter
    public class UserAccRes04 {
        private char resCode;
        private String resMsg;
        private Optional<UserVo> user;
    }

    @Getter @Setter
    public class UserAccRes05 {
        private char resCode;
        private String resMsg;
        private Long userId;
    }
}
