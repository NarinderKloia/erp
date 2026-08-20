package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateRoomDto;
import com.navi.erp.Dto.RoomDto;
import com.navi.erp.Entity.Floors;
import com.navi.erp.Entity.Rooms;
import com.navi.erp.Repository.FloorRepo;
import com.navi.erp.Repository.RoomRepo;
import com.navi.erp.Service.RoomService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    public final FloorRepo fRepo;
    public final RoomRepo rRepo;

    @Override
    public RoomDto createRoom(Long floorId, CreateRoomDto dto) {
        Floors floors = fRepo.findById(floorId).orElseThrow();
        Rooms rooms = new Rooms();
        rooms.setFloors(floors);
        rooms.setRooms(dto.getRooms());
        Rooms saveRooms = rRepo.save(rooms);
        return new RoomDto(saveRooms.getId(), saveRooms.getRooms(),
                saveRooms.getGeo_north(), saveRooms.getGeo_south(), saveRooms.getGeo_east(), saveRooms.getGeo_west(),
                saveRooms.getGeo_north_lat(), saveRooms.getGeo_south_lat(), saveRooms.getGeo_east_lat(),
                saveRooms.getGeo_west_lat(),
                saveRooms.getFloors());

    }

    @Override
    public List<RoomDto> getAllRooms() {
        List<Rooms> rooms = rRepo.findAll();
        List<RoomDto> dtoList = new ArrayList<>();
        for (Rooms room : rooms) {
            RoomDto dto = new RoomDto(room.getId(), room.getRooms(),
                    room.getGeo_north(), room.getGeo_south(), room.getGeo_east(), room.getGeo_west(),
                    room.getGeo_north_lat(), room.getGeo_south_lat(), room.getGeo_east_lat(),
                    room.getGeo_west_lat(),
                    room.getFloors());
            dtoList.add(dto);
        }
        return dtoList;

    }

}
