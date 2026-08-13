package com.navi.erp.Service.Impl;

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

    // @Override
    // public List<CourseDto> getAllCourses() {
    // List<Courses> Courses = sRepo.findAll();
    // List<CourseDto> dtoList = new ArrayList<>();
    // for (Courses Course : Courses) {
    // CourseDto dto = new CourseDto(Course.getId(),Course.getCourse());
    // dtoList.add(dto);
    // }
    // return dtoList;

    // }

    // @Override
    // public CourseDto updateCourses(Long id, CreateCourseDto dto) {
    // Courses Courses = sRepo.findById(id).orElseThrow(
    // () -> new RuntimeException("Course Not Found"));
    // Courses.setCourse(dto.getCourse());

    // Courses saveCourse = sRepo.save(Courses);

    // return new CourseDto(saveCourse.getId(),saveCourse.getCourse());

    // }

    // public CourseDto patchCourse(Long id, CreateCourseDto dto) {
    // Courses Courses = sRepo.findById(id).orElseThrow();
    // if (dto.getName() != null) {
    // Courses.setName(dto.getName());
    // }
    // if (dto.getAddress() != null) {
    // Courses.setAddress(dto.getAddress());
    // }
    // if (dto.getFatherName() != null) {
    // Courses.setFatherName(dto.getFatherName());
    // }
    // if (dto.getMobile() != null) {
    // Courses.setMobile(dto.getMobile());
    // }
    // return new CourseDto(Courses.getId(), Courses.getName(),
    // Courses.getFatherName(), Courses.getMobile(),
    // Courses.getAddress());

    // }

    // @Override
    // public String deleteCourse(Long id) {
    // sRepo.deleteById(id);
    // return null;

}
