package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDao {
    Optional<UserVo> findByEm(String email);
    Long save(String userName,
              String userEmail,
              String userTel,
              String userBirth,
              char userGender,
              String userAddr); //사용자 계정 등록

    Optional<UserVo> findById(Long aLong);

    Long updateProfile (Long userId,
                 String userName,
                 String userTel,
                 String userBirth,
                 char userGender,
                 String userAddr);

    Long updatePw (Long userId, String userPw);
}
