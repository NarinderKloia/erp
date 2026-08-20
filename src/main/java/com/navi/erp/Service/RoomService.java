package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateRoomDto;
import com.navi.erp.Dto.RoomDto;

@Service
public interface RoomService {
    public RoomDto createRoom(Long floorId, CreateRoomDto dto);
    public List<RoomDto> getAllRooms();

}
