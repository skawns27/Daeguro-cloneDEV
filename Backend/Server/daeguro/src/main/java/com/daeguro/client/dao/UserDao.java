package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;
import org.hibernate.annotations.SQLInsert;

import java.util.Optional;

public interface UserDao {
    Optional<UserVo> findByUserEm(String userEm);
    <S extends UserVo> S save(S entity);
    Optional<UserVo> findById(Long aLong);

    Void updateProfile (Long userId,
                 String userName,
                 String userTel,
                 String userBirth,
                 char userGender,
                 String userAddr);

    //Long updatePw (Long userId, String userPw);
}
