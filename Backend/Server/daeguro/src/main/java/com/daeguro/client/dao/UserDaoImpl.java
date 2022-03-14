package com.daeguro.client.dao;

import com.daeguro.client.controller.userAcc.UserAccRes04;
import com.daeguro.client.vo.UserVo;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.daeguro.lib.MySQLMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserDaoImpl extends JpaRepository<UserVo, Long>, UserDao {
    /*JpaRepository + 확장 클래스 => 자동으로 db 정보 injection (원래는 DB 정보 dataSource 객체를 호출하여 사용) */
    /*JpaRepository 확장 클래스의 구현체를 생성하여 injection*/

    @Override
    Optional<UserVo> findByUserEm(String userEm); // findBy(탐색조건이름)으로 함수 정의해야함

    @Override
    <S extends UserVo> S save(S entity);
    @Override
    List<UserVo> findAll();

    @Override
    Optional<UserVo> findById(Long aLong);


    @Modifying
    @Transactional
    @Query(value = MySQLMapping.UPDATE_USER, nativeQuery = true)
    Void updateProfile (
                @Param("userId") Long userId,
                @Param("userName") String userName,
                @Param("userTel") String userTel,
                @Param("userBirth") String userBirth,
                @Param("userGender") char userGender,
                @Param("userAddr") String userAddr);
}
