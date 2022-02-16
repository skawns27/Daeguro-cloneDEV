package com.daeguro.common.dao;

import com.daeguro.common.vo.storeVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface storeDao extends JpaRepository<storeVo, Integer> {
    /*store 테이블 데이터 처리 관련*/
}
