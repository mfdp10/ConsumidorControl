/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.web;

import com.example.persona.Persona;
import com.example.servicio.IPersonaServicio;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Mauricio
 */
@Controller
@Slf4j
public class ControladorREST {

    @Autowired
    //private IPersonaDao personaDao;
    private IPersonaServicio PersonaServicio;

    @GetMapping("/")
    public String comienzo(Model model) {

        log.info("Ejecutando controlador MVC");

        var personas = PersonaServicio.listaPersonas();

        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona p) {
        return "agregar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Persona p, Errors error) {
        if (error.hasErrors()) {
            return "agregar";
        }
        PersonaServicio.salvar(p);
        return "redirect:/";
    }

    @GetMapping("/cambiar/{idpersonas}")
    public String cambiar(Persona persona, Model model) {
        System.out.println("antes " + persona);
        persona = PersonaServicio.localizarPersona(persona);
        model.addAttribute("persona", persona);
        System.out.println("despues " + persona);
        return "agregar";
    }

    @GetMapping("/eliminar/{idpersonas}")
    public String eliminar(Persona persona) {
        System.out.println("antes " + persona);
        PersonaServicio.borrar(persona);
        return "redirect:/";
    }

}
