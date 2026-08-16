package com.navi.erp.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateTimetableDto;
import com.navi.erp.Entity.Courses;
import com.navi.erp.Entity.Programs;
import com.navi.erp.Entity.Sections;
import com.navi.erp.Entity.Subjects;
import com.navi.erp.Entity.Teachers;
import com.navi.erp.Entity.TimeTable;
import com.navi.erp.Repository.CourseRepo;
import com.navi.erp.Repository.ProgramRepo;
import com.navi.erp.Repository.SectionRepo;
import com.navi.erp.Repository.SubjectRepo;
import com.navi.erp.Repository.TeacherRepo;
import com.navi.erp.Repository.TimetableRepo;
import com.navi.erp.Service.TimetableService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepo timetableRepo;
    private final ProgramRepo programRepo;
    private final CourseRepo courseRepo;
    private final SectionRepo sectionRepo;
    private final TeacherRepo teacherRepo;
    private final SubjectRepo subjectRepo;

    @Override
    public TimeTable createTimetable(CreateTimetableDto dto) {

        Programs program = programRepo.findById(dto.getProgramId())
                .orElseThrow(() -> new RuntimeException("Program Not Found"));

        Courses course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course Not Found"));

        Sections section = sectionRepo.findById(dto.getSectionId())
                .orElseThrow(() -> new RuntimeException("Section Not Found"));

        Teachers teacher = teacherRepo.findById(dto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher Not Found"));

        Subjects subject = subjectRepo.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject Not Found"));

        TimeTable timetable = new TimeTable();

        timetable.setDay(dto.getDay());
        timetable.setProgram(program);
        timetable.setCourse(course);
        timetable.setSection(section);
        timetable.setStartFrom(dto.getStartFrom());
        timetable.setEndTo(dto.getEndTo());
        timetable.setTeacher(teacher);
        timetable.setSubject(subject);

        return timetableRepo.save(timetable);
    }

    @Override
    public List<TimeTable> getAllTimetables() {
        return timetableRepo.findAll();
    }
}