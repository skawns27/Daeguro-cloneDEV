package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;
import org.hibernate.annotations.SQLInsert;

import java.util.Optional;

public interface UserDao {
    Optional<UserVo> findByUserEm(String userEm);
    /*Void save(String userName,
              String userEm,
              String userPw,
              String userTel,
              String userBirth,
              char userGender,
              String userAddr);*/ //사용자 계정 등록
    <S extends UserVo> S save(S entity);
    Optional<UserVo> findById(Long aLong);

    /*Long updateProfile (Long userId,
                 String userName,
                 String userTel,
                 String userBirth,
                 char userGender,
                 String userAddr);
*/
    //Long updatePw (Long userId, String userPw);
}
