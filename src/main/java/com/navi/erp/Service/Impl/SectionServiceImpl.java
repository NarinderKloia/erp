package com.navi.erp.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.SectionDto;
import com.navi.erp.Dto.CreateSectionDto;
import com.navi.erp.Entity.Sections;
import com.navi.erp.Entity.Courses;
import com.navi.erp.Repository.SectionRepo;
import com.navi.erp.Repository.CourseRepo;
import com.navi.erp.Service.SectionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SectionServiceImpl implements SectionService {
    private final CourseRepo pRepo;
    private final SectionRepo cRepo;

    @Override
    public SectionDto CreateSection(Long CourseId, CreateSectionDto dto) {
        Courses Courses = pRepo.findById(CourseId).orElseThrow(
                () -> new RuntimeException("Course Not Found"));

        Sections Sections = new Sections();
        Sections.setCourses(Courses);
        Sections.setSection(dto.getSection());
        Sections saveSection = cRepo.save(Sections);

        return new SectionDto(saveSection.getId(), saveSection.getSection(), saveSection.getCourses());

    }

    @Override
    public List<SectionDto> getSectionById(Long CourseId) {
        pRepo.findById(CourseId).orElseThrow(
                () -> new RuntimeException("Course Not Found"));

        List<Sections> Sections = cRepo.findByCoursesId(CourseId);

        return Sections.stream()
                .map(Section -> new SectionDto(
                        Section.getId(),
                        Section.getSection(),
                        Section.getCourses()))
                .toList();

    }

    @Override
    public String deleteSection(Long id) {
        cRepo.deleteById(id);
        return "Section Deleted Successfully";

       
    }

}
