package com.example.lab7.repository;

import com.example.lab7.dto.EquiposPorPaisDto;
import com.example.lab7.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {

    @Query(value = "SELECT c.country as pais, count(*) as cantidad FROM location l inner join site s on l.LocationID=s.LocationID inner join device d on s.SiteID = d.SiteID GROUP BY c.country",
            nativeQuery = true)
    List<EquiposPorPaisDto> obtenerEquiposPorPais();
}
