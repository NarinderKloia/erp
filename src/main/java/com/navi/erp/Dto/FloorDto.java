package com.navi.erp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FloorDto {

    private Long id;
    private String floor;
    private BlockDto block;
}