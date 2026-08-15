package com.navi.erp.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CourseDto;
import com.navi.erp.Dto.CreateCourseDto;
import com.navi.erp.Entity.Courses;
import com.navi.erp.Entity.Programs;
import com.navi.erp.Repository.CourseRepo;
import com.navi.erp.Repository.ProgramRepo;
import com.navi.erp.Service.CourseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final ProgramRepo pRepo;
    private final CourseRepo cRepo;

    @Override
    public CourseDto CreateCourse(Long programId, CreateCourseDto dto) {
        Programs programs = pRepo.findById(programId).orElseThrow(
                () -> new RuntimeException("Program Not Found"));

        Courses courses = new Courses();
        courses.setPrograms(programs);
        courses.setCourse(dto.getCourse());
        Courses saveCourse = cRepo.save(courses);

        return new CourseDto(saveCourse.getId(), saveCourse.getCourse(), saveCourse.getPrograms());

    }

    @Override
    public List<CourseDto> getCourseById(Long programId) {
        pRepo.findById(programId).orElseThrow(
                () -> new RuntimeException("Program Not Found"));

        List<Courses> courses = cRepo.findByProgramsId(programId);

        return courses.stream()
                .map(course -> new CourseDto(
                        course.getId(),
                        course.getCourse(),
                        course.getPrograms()))
                .toList();

    }

    @Override
    public String deleteCourse(Long id) {
        cRepo.deleteById(id);
        return "Course Deleted Successfully";

       
    }

}
