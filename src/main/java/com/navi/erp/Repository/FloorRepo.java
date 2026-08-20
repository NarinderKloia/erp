package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Floors;

public interface FloorRepo extends JpaRepository<Floors, Long> {
}