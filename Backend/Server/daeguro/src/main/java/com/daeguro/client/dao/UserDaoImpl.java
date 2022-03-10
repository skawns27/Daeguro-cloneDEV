package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.daeguro.lib.MySQLMapping;

import java.util.List;
import java.util.Optional;

public interface UserDaoImpl extends JpaRepository<UserVo, Long>, UserDao {
    /*JpaRepository + 확장 클래스 => 자동으로 db 정보 injection (원래는 DB 정보 dataSource 객체를 호출하여 사용) */
    /*JpaRepository 확장 클래스의 구현체를 생성하여 injection*/

    @Override
    Optional<UserVo> findByUserEm(String userEm);

   /* @Override
    @Query(value = MySQLMapping.INSERT_DATA, nativeQuery = true)
    Void save(@Param(value = "userName") String userName,
              @Param(value = "userEm") String userEm,
              @Param(value = "userPw") String userPw,
              @Param(value = "userTel") String userTel,
              @Param(value = "userBirth") String userBirth,
              @Param(value = "userGender") char userGender,
              @Param(value = "userAddr") String userAddr);*/

    @Override
    <S extends UserVo> S save(S entity);
/*    @Override
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
                 @Param(value = "userAddr") String userAddr);*/
}
