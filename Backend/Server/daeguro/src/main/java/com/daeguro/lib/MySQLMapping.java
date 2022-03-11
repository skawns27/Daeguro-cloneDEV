package com.daeguro.lib;

public interface MySQLMapping {
    String UPDATE_USER = "UPDATE userTB " +
                                "SET userName = :userName, " +
                                    "userTel = :userTel, " +
                                    "userBirth = :userBirth, " +
                                    "userGender = :userGender, " +
                                    "userAddr = :userAddr " +
                            "WHERE userId = :userId";

    String INSERT_DATA = "INSERT INTO userTB(userName, userEm, userPw, userTel, userBirth, userGender, userAddr) VALUES(:userName, :userEm, :userPw, :userTel, :userBirth, :userGender, :userAddr)";

            /*private String userName;
    private String userEmail; //db테이블에 추가 필요
    private String userPw;  //db테이블에 추가 필요
    private String userTel;
    private String userBirth;
    private char userGender;
    private String userAddr;*/
}
