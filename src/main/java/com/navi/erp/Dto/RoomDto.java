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
public class RoomDto {
    private Long id;
    private String Rooms;
    private Floors floors;
}
