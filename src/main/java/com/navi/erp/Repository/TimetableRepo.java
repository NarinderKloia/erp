package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.TimeTable;

public interface TimetableRepo extends JpaRepository<TimeTable, Long> {

}