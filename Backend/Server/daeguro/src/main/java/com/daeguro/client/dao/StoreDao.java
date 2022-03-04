package com.daeguro.client.dao;

import com.daeguro.client.vo.storeVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDao extends JpaRepository<storeVo, Integer> {
    /*store 테이블 데이터 처리 관련*/
}
