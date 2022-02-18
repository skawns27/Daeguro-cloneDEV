package com.daeguro.common.dao;

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
    /*내 정보 조회*/
    @Override
    public Optional<UserVo> findById(Long id) {
         List<UserVo> result = em.createQuery(findByIdSQL, UserVo.class)
                 .setParameter("userId", id)
                 .getResultList();
        return Optional.empty();
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
