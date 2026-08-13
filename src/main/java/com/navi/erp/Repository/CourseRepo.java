package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Courses;

public interface CourseRepo extends JpaRepository<Courses, Long> {

}
