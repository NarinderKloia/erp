package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CourseDto;
import com.navi.erp.Dto.CreateCourseDto;

@Service
public interface CourseService {
    public CourseDto CreateCourse(Long programId, CreateCourseDto dto);

    public List<CourseDto> getCourseById(Long programId);

    public String deleteCourse(Long id);
}
