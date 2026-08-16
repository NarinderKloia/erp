package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateSubjectDto;
import com.navi.erp.Dto.SubjectDto;
import com.navi.erp.Entity.Subjects;
import com.navi.erp.Repository.SubjectRepo;
import com.navi.erp.Service.SubjectService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    public final SubjectRepo sRepo;

    @Override
    public SubjectDto createSubject(CreateSubjectDto dto) {
        
        Subjects subjects = new Subjects();
        subjects.setSubject(dto.getSubject());
        subjects.setSCode(dto.getSCode());
        subjects.setICompulsory(dto.isICompulsory());
        Subjects saveSubjects = sRepo.save(subjects);

        return new SubjectDto(saveSubjects.getId(), saveSubjects.getSubject(), saveSubjects.getSCode(),
                saveSubjects.isICompulsory());

    }

    @Override
    public List<SubjectDto> getAllSubject() {
        List<Subjects> subjects = sRepo.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (Subjects subject : subjects) {
            SubjectDto dto = new SubjectDto(subject.getId(), subject.getSubject(), subject.getSCode(),
                    subject.isICompulsory());
            subjectDtos.add(dto);
        }
        return subjectDtos;

    }

}
