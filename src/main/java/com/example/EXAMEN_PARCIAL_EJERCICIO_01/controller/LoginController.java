/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EXAMEN_PARCIAL_EJERCICIO_01.controller;
import com.example.EXAMEN_PARCIAL_EJERCICIO_01.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Jeanc
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario()); // Objeto vacío para el formulario
        return "login"; // Devuelve la vista login.html
    }

    @PostMapping("/login")
    public String procesarLogin(@Valid Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login"; // Si hay errores, vuelve al formulario
        }

        // Validación básica de credenciales
        if ("admin".equals(usuario.getUsername()) && "admin".equals(usuario.getPassword())) {
            return "redirect:/exito"; // Redirige a la vista de éxito
        } else {
            model.addAttribute("error", "Credenciales inválidas. Inténtalo de nuevo.");
            return "login"; // Vuelve al formulario con mensaje de error
        }
    }

    @GetMapping("/exito")
    public String mostrarExito() {
        return "exito"; // Vista de éxito
    }
}
