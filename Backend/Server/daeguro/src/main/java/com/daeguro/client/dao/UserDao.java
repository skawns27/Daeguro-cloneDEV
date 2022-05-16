package com.daeguro.client.dao;

import com.daeguro.client.controller.userAcc.UserAccRes04;
import com.daeguro.client.vo.UserVo;
import java.util.Optional;

public interface UserDao {
    /*회원이메일 조회*/
    Optional<UserVo> findByUserEm(String userEm);
    /*회원가입 기능*/
    <S extends UserVo> S save(S entity);
    /*회원ID 조회*/
    Optional<UserVo> findById(Long aLong);
    /*사용자 정보 업데이트 : 비밀번호 제외*/
    Void updateProfile (Long userId,
                        String userName,
                        String userTel,
                        String userBirth,
                        char userGender,
                        String userAddr);

    //Long updatePw (Long userId, String userPw);
}
