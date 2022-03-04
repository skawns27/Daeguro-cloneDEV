package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;

import java.util.Optional;

public interface UserDao {
    Optional<UserVo> findByEm(String email);
    Long save(UserVo userVo); //사용자 계정 등록
}
