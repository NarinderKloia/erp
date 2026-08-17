package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Blocks;

public interface BlockRepo extends JpaRepository<Blocks, Long> {
}
