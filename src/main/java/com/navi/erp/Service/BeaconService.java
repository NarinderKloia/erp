package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.BeaconDto;
import com.navi.erp.Dto.CreateBeaconDto;

@Service
public interface BeaconService {
    public BeaconDto createBeacon(Long floorId, CreateBeaconDto dto);
    public List<BeaconDto> getAllBeacons();
    
}
