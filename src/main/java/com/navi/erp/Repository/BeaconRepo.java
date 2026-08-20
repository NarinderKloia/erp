package com.navi.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.erp.Entity.Beacons;

public interface BeaconRepo extends JpaRepository<Beacons, Long> {

}
