package com.daeguro.lib;

public interface MySQLMapping {
    String UPDATE_USER = "UPDATE userTB " +
                        "u SET u.name, " +
                        "u.userPw, u.userTel, " +
                        "u.userBirth" +
                        "u.userGender" +
                        "u.Addr" +
                    " WHERE u.userId = :id";
}
