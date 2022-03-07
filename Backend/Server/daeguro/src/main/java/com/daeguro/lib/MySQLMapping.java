package com.daeguro.lib;

public interface MySQLMapping {
    String UPDATE_USER = "UPDATE userTB " +
                        "u SET u.name, " +
                        "u.userPw, u.userTel, " +
                        "u.userBirth" +
                        "u.userGender" +
                        "u.Addr" +
                    " WHERE u.userId = :id";

    String INSERT_DATA = "INSERT INTO userTB" +
                                "(userName, " +
                                "userEmail, " +
                                "userPw, " +
                                "userTel, " +
                                "userTel, " +
                                "userBirth, " +
                                "userGender, " +
                                "userAddr) " +
                            "VALUES" +
                                "(:userName, " +
                                ":userEmail, " +
                                ":userPw, " +
                                ":userTel, " +
                                ":userTel, " +
                                ":userBirth, " +
                                ":userGender, " +
                                ":userAddr) " +
                        "SELECT LAST_INSERT_ID()";

            /*private String userName;
    private String userEmail; //db테이블에 추가 필요
    private String userPw;  //db테이블에 추가 필요
    private String userTel;
    private String userBirth;
    private char userGender;
    private String userAddr;*/
}
