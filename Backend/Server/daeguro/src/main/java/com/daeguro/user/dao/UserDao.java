package com.daeguro.user.dao;

import com.daeguro.user.controller.userAcc.UserAccRes04;
import com.daeguro.user.vo.UserVO;
import java.util.Optional;

public interface UserDao {
    /*회원이메일 조회*/
    Optional<UserVO> findByUserEm(String userEm);
    /*회원가입 기능*/
    <S extends UserVO> S save(S entity);
    /*회원ID 조회*/
    Optional<UserVO> findById(Long aLong);
    /*사용자 정보 업데이트 : 비밀번호 제외*/
    Void updateProfile (Long userId,
                        String userName,
                        String userTel,
                        String userBirth,
                        char userGender,
                        String userAddr);

    //Long updatePw (Long userId, String userPw);
}
