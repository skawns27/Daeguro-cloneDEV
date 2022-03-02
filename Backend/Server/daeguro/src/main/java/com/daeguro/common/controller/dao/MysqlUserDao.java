package com.daeguro.common.controller.dao;

import com.daeguro.common.vo.UserVo;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class MysqlUserDao implements UserDao{
    private final EntityManager em;
    private final String findByEmSQL = "SELECT * FROM userTB WHERE userEm = :email";
    private final String findByIdSQL = "SELECT * FROM userTB WHERE userId = :id";

    public MysqlUserDao(EntityManager em) {
         this.em = em;
    }

    /*로그인: DB 이메일 조회*/
    @Override
    public Optional<UserVo> findByEm(String email) {
        List<UserVo> result = em.createQuery(findByEmSQL, UserVo.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().findAny();
    }
    /*회원가입*/
    @Override
    public long save(UserVo userVo) {
        em.persist(userVo);
        return userVo.getUserId();
    }
}
