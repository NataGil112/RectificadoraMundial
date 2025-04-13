package com.rm.rectificadoraMundial.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rm.rectificadoraMundial.mediador.UsuarioMediador;
import com.rm.rectificadoraMundial.modelo.Usuario;

@Controller
public class LoginController {

    // Vista del login
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    // Procesa el formulario
    @PostMapping("/login")
    public String validarLogin(@RequestParam String cedula,
                                @RequestParam String pass,
                                Model model) {
    	
    	UsuarioMediador mediador = new UsuarioMediador();
    	Usuario usuario = mediador.login(cedula, pass);

        	 return "redirect:/bienvenido";
    }

    // Página de bienvenida
    @GetMapping("/bienvenido")
    public String bienvenido() {
        return "bienvenido";
    }
}