package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateProgramDto;
import com.navi.erp.Dto.ProgramDto;

@Service
public interface ProgramService {
    public ProgramDto createProgram(CreateProgramDto dto);

    public List<ProgramDto> getAllPrograms();

    public ProgramDto updatePrograms(Long id, CreateProgramDto dto);

    // public ProgramDto patchProgram(Long id, CreateProgramDto dto);

    public String deleteProgram(Long id);
}
