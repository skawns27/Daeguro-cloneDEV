package com.daeguro.common.dao;

import com.daeguro.common.vo.UserVo;

import java.util.Optional;

public interface UserDao {
    Optional<UserVo> findById(Long id);
    Optional<UserVo> findByEm(String email);
    long save(UserVo userVo); //사용자 계정 등록
}
