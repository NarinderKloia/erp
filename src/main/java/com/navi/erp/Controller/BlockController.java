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

import com.navi.erp.Dto.BlockDto;
import com.navi.erp.Dto.CreateBlockDto;
import com.navi.erp.Service.BlockService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/programs/{programId}/blocks")
@AllArgsConstructor
public class BlockController {
    public final BlockService service;

    @PostMapping
    public ResponseEntity<BlockDto> createBlock(@PathVariable Long programId, @RequestBody CreateBlockDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBlock(programId, dto));
    };

    @GetMapping
    public ResponseEntity<List<BlockDto>> getAllBlocks() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBlocks());
    };
}
