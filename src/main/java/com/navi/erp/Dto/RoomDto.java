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
    private String geo_north;
    private String geo_south;
    private String geo_east;
    private String geo_west;
    private String geo_north_lat;
    private String geo_south_lat;
    private String geo_east_lat;
    private String geo_west_lat;
    private Floors floors;
}
