package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface JpaUserDao extends JpaRepository<UserVo, Long>, UserDao {
//JpaRepository + 확장 클래스 => 자동으로 db 정보 injection (원래는 DB정보를 dataSource객체를 호출하여 사용)
//
//JpaRepository 확장 클래스의 구현체를 생성하여 injection


    @Override
    Optional<UserVo> findByEm(String email);

    @Override
    Long save(UserVo userVo);

    @Override
    List<UserVo> findAll();

    @Override
    Optional<UserVo> findById(Long aLong);
}
