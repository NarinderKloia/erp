package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateBeaconDto;
import com.navi.erp.Dto.BeaconDto;
import com.navi.erp.Entity.Floors;
import com.navi.erp.Entity.Beacons;
import com.navi.erp.Repository.FloorRepo;
import com.navi.erp.Repository.BeaconRepo;
import com.navi.erp.Service.BeaconService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BeaconServiceImpl implements BeaconService {
    public final FloorRepo fRepo;
    public final BeaconRepo rRepo;

    @Override
    public BeaconDto createBeacon(Long floorId, CreateBeaconDto dto) {
        Floors floors = fRepo.findById(floorId).orElseThrow();
        Beacons beacons = new Beacons();
        beacons.setFloors(floors);
        beacons.setLabel(dto.getLabel());
        beacons.setMAC(dto.getMAC());
        beacons.setMajor(dto.getMajor());
        beacons.setMinor(dto.getMinor());
        beacons.setUUID(dto.getUUID());
        Beacons saveBeacons = rRepo.save(beacons);
        return new BeaconDto(saveBeacons.getId(), saveBeacons.getLabel(), saveBeacons.getMAC(), saveBeacons.getUUID(),
                saveBeacons.getMajor(), saveBeacons.getMinor(), saveBeacons.getFloors());

    }

    @Override
    public List<BeaconDto> getAllBeacons() {
        List<Beacons> beacons = rRepo.findAll();
        List<BeaconDto> dtoList = new ArrayList<>();
        for (Beacons saveBeacons : beacons) {
            BeaconDto dto = new BeaconDto(saveBeacons.getId(), saveBeacons.getLabel(), saveBeacons.getMAC(),
                    saveBeacons.getUUID(),
                    saveBeacons.getMajor(), saveBeacons.getMinor(), saveBeacons.getFloors());
                    dtoList.add(dto);
        }
        return dtoList;

    }

}
