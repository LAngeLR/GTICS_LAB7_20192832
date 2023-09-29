package com.example.lab7.controller;

import com.example.lab7.entity.Technician;
import com.example.lab7.repository.DeviceRepository;
import com.example.lab7.repository.LocationRepository;
import com.example.lab7.repository.SiteRepository;
import com.example.lab7.repository.TechnicianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/equipos")
public class EquiposController {

    final DeviceRepository deviceRepository;
    final LocationRepository locationRepository;
    final SiteRepository siteRepository;

    public EquiposController(DeviceRepository deviceRepository,LocationRepository locationRepository,SiteRepository siteRepository) {
        this.deviceRepository = deviceRepository;
        this.locationRepository = locationRepository;
        this.siteRepository = siteRepository;
    }

    @GetMapping("/listaEquipos")
    public String listarEquipos(Model model) {

        model.addAttribute("listaEquiposPais", deviceRepository.obtenerEquiposPorPais());

        return "Estadisticas/listaEquipos";
    }
}
