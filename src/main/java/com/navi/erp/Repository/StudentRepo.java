package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Students;

public interface StudentRepo extends JpaRepository<Students, Long> {

}
