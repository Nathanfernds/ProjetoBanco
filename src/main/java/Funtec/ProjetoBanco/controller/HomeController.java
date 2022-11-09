package Funtec.ProjetoBanco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Funtec.ProjetoBanco.model.Cliente;
import Funtec.ProjetoBanco.model.repository.ClienteRepository;

public class HomeController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/home")
    public String home(Model model){
        List<Cliente> cliente = clienteRepository.findAll();

        model.addAttribute("cliente",cliente);
        return "home";
    }
}