package com.navi.erp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.erp.Dto.FloorDto;
import com.navi.erp.Dto.CreateFloorDto;
import com.navi.erp.Service.FloorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/blocks/{blockId}/floors")
@AllArgsConstructor
public class FloorController {
    public final FloorService service;

    @PostMapping
    public ResponseEntity<FloorDto> createFloor(@PathVariable Long blockId, @RequestBody CreateFloorDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createFloor(blockId, dto));
    };

    @GetMapping
    public ResponseEntity<List<FloorDto>> getAllFloors() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllFloors());
    };
}
