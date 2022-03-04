package com.daeguro.client.dao;

import com.daeguro.client.vo.UserVo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface JpaUserDao extends JpaRepository<UserDao, Long>, UserDao {
    /*JpaRepository + 확장 클래스 => 자동으로 db 정보 injection (원래는 DB정보를 dataSource객체를 호출하여 사용) */
    /*JpaRepository 확장 클래스의 구현체를 생성하여 injection*/
    @Override
    Optional<UserVo> findByEm(String email);

    @Override
    Long save(UserVo userVo);

    @Override
    List<UserDao> findAll();

    @Override
    List<UserDao> findAll(Sort sort);

    @Override
    List<UserDao> findAllById(Iterable<Long> longs);

    @Override
    <S extends UserDao> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends UserDao> S saveAndFlush(S entity);

    @Override
    <S extends UserDao> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<UserDao> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    UserDao getOne(Long aLong);

    @Override
    UserDao getById(Long aLong);

    @Override
    <S extends UserDao> List<S> findAll(Example<S> example);

    @Override
    <S extends UserDao> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<UserDao> findAll(Pageable pageable);

    @Override
    <S extends UserDao> S save(S entity);

    @Override
    Optional<UserDao> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(UserDao entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends UserDao> entities);

    @Override
    void deleteAll();

    @Override
    <S extends UserDao> Optional<S> findOne(Example<S> example);

    @Override
    <S extends UserDao> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends UserDao> long count(Example<S> example);

    @Override
    <S extends UserDao> boolean exists(Example<S> example);

    @Override
    <S extends UserDao, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
