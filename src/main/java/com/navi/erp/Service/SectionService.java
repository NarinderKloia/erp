package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.SectionDto;
import com.navi.erp.Dto.CreateSectionDto;

@Service
public interface SectionService {
    public SectionDto CreateSection(Long courseId, CreateSectionDto dto);

    public List<SectionDto> getSectionById(Long courseId);

    public String deleteSection(Long id);
}
