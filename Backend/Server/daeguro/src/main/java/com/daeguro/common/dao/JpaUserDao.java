package com.daeguro.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserDao extends JpaRepository<UserDao, Long>, UserDao {
}
