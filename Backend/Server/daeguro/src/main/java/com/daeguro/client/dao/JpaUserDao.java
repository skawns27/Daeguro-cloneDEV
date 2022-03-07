package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.daeguro.lib.MySQLMapping;

import java.util.List;
import java.util.Optional;

public interface JpaUserDao extends JpaRepository<UserVo, Long>, UserDao {
    /*JpaRepository + 확장 클래스 => 자동으로 db 정보 injection (원래는 DB 정보 dataSource 객체를 호출하여 사용) */
    /*JpaRepository 확장 클래스의 구현체를 생성하여 injection*/

    @Override
    Optional<UserVo> findByEm(String email);

    @Override
    @Query(MySQLMapping.INSERT_DATA)
    Long save(@Param(value = "userName") String userName,
              @Param(value = "userEmail") String userEmail,
              @Param(value = "userTel") String userTel,
              @Param(value = "userBirth") String userBirth,
              @Param(value = "userName") char userGender,
              @Param(value = "userAddr") String userAddr);

    @Override
    List<UserVo> findAll();

    @Override
    Optional<UserVo> findById(Long aLong);

    @Modifying
    @Query(MySQLMapping.UPDATE_USER)
    Long updateProfile (@Param(value = "userId") Long userId,
                 @Param(value = "userName") String userName,
                 @Param(value = "userTel") String userTel,
                 @Param(value = "userBirth") String userBirth,
                 @Param(value = "userGender") char userGender,
                 @Param(value = "userAddr") String userAddr);
}
