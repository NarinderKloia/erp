package com.navi.erp.Dto;

import com.navi.erp.Entity.Blocks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateFloorDto {
    private String floor;

    private Blocks blocks;
}
