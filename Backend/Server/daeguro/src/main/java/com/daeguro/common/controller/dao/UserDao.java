package com.daeguro.common.controller.dao;

import com.daeguro.common.vo.UserVo;

import java.util.Optional;

public interface UserDao {
    Optional<UserVo> findByEm(String email);
    long save(UserVo userVo); //사용자 계정 등록
}
