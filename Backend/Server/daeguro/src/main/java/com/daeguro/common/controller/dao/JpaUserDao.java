package com.daeguro.common.controller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserDao extends JpaRepository<UserDao, Long>, UserDao {
    /*JpaRepository + 확장 클래스 => 자동으로 db 정보 injection (원래는 DB정보를 dataSource객체를 호출하여 사용) */

}
