package com.navi.erp.Dto;

import com.navi.erp.Entity.Floors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeaconDto {
    private Long id;
    private String Label;
    private String MAC;
    private String UUID;
    private String Major;
    private String Minor;
    private Floors floors;
}
