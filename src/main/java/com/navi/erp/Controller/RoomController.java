package com.navi.erp.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.erp.Dto.CreateRoomDto;
import com.navi.erp.Dto.RoomDto;
import com.navi.erp.Service.RoomService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/floors/{floorId}/rooms")
@AllArgsConstructor
public class RoomController {
    public final RoomService service;

    @PostMapping
    public RoomDto createRoom(@PathVariable Long floorId, @RequestBody CreateRoomDto dto) {
        return service.createRoom(floorId, dto);
    }

    @GetMapping
    public List<RoomDto> getAllRooms() {
        return service.getAllRooms();
    }
}
