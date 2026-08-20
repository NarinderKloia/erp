package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.BlockDto;
import com.navi.erp.Dto.CreateFloorDto;
import com.navi.erp.Dto.FloorDto;
import com.navi.erp.Entity.Blocks;
import com.navi.erp.Entity.Floors;
import com.navi.erp.Repository.BlockRepo;
import com.navi.erp.Repository.FloorRepo;
import com.navi.erp.Service.FloorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FloorServiceImpl implements FloorService {

    private final FloorRepo brepo;
    private final BlockRepo pRepo;

    @Override
    public FloorDto createFloor(Long blockId, CreateFloorDto dto) {

        Blocks block = pRepo.findById(blockId).orElseThrow();

        Floors floor = new Floors();
        floor.setFloor(dto.getFloor());
        floor.setBlock(block);

        Floors savedFloor = brepo.save(floor);

        BlockDto blockDto = new BlockDto(
                block.getId(),
                block.getBlock(),
                block.getPrograms()
        );

        return new FloorDto(
                savedFloor.getId(),
                savedFloor.getFloor(),
                blockDto);
    }

    @Override
    public List<FloorDto> getAllFloors() {

        List<Floors> floors = brepo.findAll();
        List<FloorDto> dtoList = new ArrayList<>();

        for (Floors floor : floors) {

            BlockDto blockDto = new BlockDto(
                    floor.getBlock().getId(),
                    floor.getBlock().getBlock(),
                    floor.getBlock().getPrograms());

            dtoList.add(new FloorDto(
                    floor.getId(),
                    floor.getFloor(),
                    blockDto));
        }

        return dtoList;
    }
}