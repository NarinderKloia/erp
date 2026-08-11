package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Teachers;

public interface TeacherRepo extends JpaRepository<Teachers, Long> {

}
