package com.navi.erp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beacons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "beacon_name", nullable = false)
    private String Label;

    @Column(nullable = false)
    private String MAC;

    @Column(nullable = false)
    private String UUID;

    @Column(nullable = false)
    private String Major;

    @Column(nullable = false)
    private String Minor;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floors floors;
}
