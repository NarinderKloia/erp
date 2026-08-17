package com.navi.erp.Dto;

import com.navi.erp.Entity.Programs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlockDto {
    private Long id;
    private String block;
    private Programs programs;
}
