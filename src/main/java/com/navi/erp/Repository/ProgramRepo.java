package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Programs;

public interface ProgramRepo extends JpaRepository<Programs, Long> {

}
