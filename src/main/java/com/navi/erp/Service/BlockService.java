package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.BlockDto;
import com.navi.erp.Dto.CreateBlockDto;

@Service
public interface BlockService {
    public BlockDto createBlock(Long programId, CreateBlockDto dto);
    public List<BlockDto> getAllBlocks();
}
