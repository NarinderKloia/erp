package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.BlockDto;
import com.navi.erp.Dto.CreateBlockDto;
import com.navi.erp.Entity.Blocks;
import com.navi.erp.Entity.Programs;
import com.navi.erp.Repository.BlockRepo;
import com.navi.erp.Repository.ProgramRepo;
import com.navi.erp.Service.BlockService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlockServiceImpl implements BlockService {
    public final BlockRepo brepo;
    public final ProgramRepo pRepo;

    @Override
    public BlockDto createBlock(Long programId, CreateBlockDto dto) {
        Programs programs = pRepo.findById(programId).orElseThrow();
        Blocks blocks = new Blocks();
        blocks.setBlock(dto.getBlock());
        blocks.setPrograms(programs);
        Blocks saveBlocks = brepo.save(blocks);
        return new BlockDto(saveBlocks.getId(), saveBlocks.getBlock(), saveBlocks.getPrograms());
    }

    @Override
    public List<BlockDto> getAllBlocks() {
        List<Blocks> blocks = brepo.findAll();
        List<BlockDto> dto = new ArrayList<>();
        for (Blocks createBlock : blocks) {
            BlockDto blockDto = new BlockDto(createBlock.getId(), createBlock.getBlock(), createBlock.getPrograms());
            dto.add(blockDto);
        }
        return dto;
    }

}
