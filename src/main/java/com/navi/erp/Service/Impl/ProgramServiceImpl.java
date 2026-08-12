package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateProgramDto;
import com.navi.erp.Dto.ProgramDto;
import com.navi.erp.Entity.Programs;
import com.navi.erp.Repository.ProgramRepo;
import com.navi.erp.Service.ProgramService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepo sRepo;

    @Override
    public ProgramDto createProgram(CreateProgramDto dto) {
        Programs programs = new Programs();
        programs.setProgram(dto.getProgram());
        Programs saveProgram = sRepo.save(programs);
        return new ProgramDto(saveProgram.getId(),saveProgram.getProgram());
    }

    @Override
    public List<ProgramDto> getAllPrograms() {
        List<Programs> Programs = sRepo.findAll();
        List<ProgramDto> dtoList = new ArrayList<>();
        for (Programs Program : Programs) {
            ProgramDto dto = new ProgramDto(Program.getId(),Program.getProgram());
            dtoList.add(dto);
        }
        return dtoList;

    }

    @Override
    public ProgramDto updatePrograms(Long id, CreateProgramDto dto) {
        Programs programs = sRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Program Not Found"));
        programs.setProgram(dto.getProgram());

        Programs saveProgram = sRepo.save(programs);

        return new ProgramDto(saveProgram.getId(),saveProgram.getProgram());

    }

    // public ProgramDto patchProgram(Long id, CreateProgramDto dto) {
    //     Programs Programs = sRepo.findById(id).orElseThrow();
    //     if (dto.getName() != null) {
    //         Programs.setName(dto.getName());
    //     }
    //     if (dto.getAddress() != null) {
    //         Programs.setAddress(dto.getAddress());
    //     }
    //     if (dto.getFatherName() != null) {
    //         Programs.setFatherName(dto.getFatherName());
    //     }
    //     if (dto.getMobile() != null) {
    //         Programs.setMobile(dto.getMobile());
    //     }
    //     return new ProgramDto(Programs.getId(), Programs.getName(), Programs.getFatherName(), Programs.getMobile(),
    //             Programs.getAddress());

    // }

    @Override
    public String deleteProgram(Long id) {
        sRepo.deleteById(id);
        return null;

    };

}
