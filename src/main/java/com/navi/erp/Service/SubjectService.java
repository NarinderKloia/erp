package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateSubjectDto;
import com.navi.erp.Dto.SubjectDto;

@Service
public interface SubjectService {
    public SubjectDto createSubject(CreateSubjectDto dto);

    public List<SubjectDto> getAllSubject();
}
