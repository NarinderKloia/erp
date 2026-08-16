package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Subjects;


public interface SubjectRepo extends JpaRepository<Subjects,Long>{

    
}