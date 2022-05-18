package com.daeguro.user.dao;

import com.daeguro.user.vo.storeVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDao extends JpaRepository<storeVO, Integer> {
    /*store 테이블 데이터 처리 관련*/
}
