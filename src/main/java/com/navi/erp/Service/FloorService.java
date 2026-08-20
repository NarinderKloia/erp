package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.FloorDto;
import com.navi.erp.Dto.CreateFloorDto;

@Service
public interface FloorService {
    public FloorDto createFloor(Long programId, CreateFloorDto dto);
    public List<FloorDto> getAllFloors();
    
}
