package com.navi.erp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlockSummaryDto {
    private Long id;
    private String block;
    private ProgramDto program;
}