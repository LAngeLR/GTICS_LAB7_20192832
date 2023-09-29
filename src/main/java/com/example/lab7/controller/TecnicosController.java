package com.example.lab7.controller;

import com.example.lab7.entity.Technician;
import com.example.lab7.repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tecnicos")
public class TecnicosController {

    final TechnicianRepository technicianRepository;

    public TecnicosController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @GetMapping("/listaTecnicos")
    public String listarEstudiantes(Model model) {

        List<Technician> listaTecnicos = technicianRepository.findAll();
        model.addAttribute("listaTecnicos", listaTecnicos);

        return "Tecnico/listaTecnicos";
    }

    @GetMapping("/new")
    public String nuevoProductoFrm(Model model, @ModelAttribute("tecnico") Technician technician) {
        return "Tecnico/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("tecnico") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal


                if (technician.getTechnicianId() == 0) {
                    attr.addFlashAttribute("msg", "Tecnico" + technician.getFirstName() + technician.getLastName() + " creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Tecnico" + technician.getFirstName() + technician.getLastName() + " actualizado exitosamente");
                }
                technicianRepository.save(technician);
                return "redirect:/tecnicos/listaTecnicos";


        } else {
            return "Tecnico/editFrm";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("tecnico") Technician technician,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optProduct = technicianRepository.findById(id);

        if (optProduct.isPresent()) {
            technician = optProduct.get();
            model.addAttribute("tecnico", technician);
            return "Tecnico/editFrm";
        } else {
            return "redirect:/tecnicos/listaTecnicos";
        }
    }
}
