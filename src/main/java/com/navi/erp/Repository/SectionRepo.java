package com.navi.erp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Sections;

public interface SectionRepo extends JpaRepository<Sections, Long> {
    List<Sections> findByCoursesId(Long courseId);

}
