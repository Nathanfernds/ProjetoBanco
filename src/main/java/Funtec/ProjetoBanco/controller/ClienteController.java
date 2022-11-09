package Funtec.ProjetoBanco.controller;

import javax.validation.Valid;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Funtec.ProjetoBanco.model.Cliente;
import Funtec.ProjetoBanco.model.repository.ClienteRepository;

@Controller
public class ClienteController {
	private ClienteRepository clicRepository;
	
	// Acessa o formulario
	@GetMapping("/form")
	public String clientesFrom(Cliente cliente) {
		return "addClientesFrom";
	}
	
	// Adiciona novo cliente
	@PostMapping("/add")
	public String novo (@Valid Cliente cliente, BindingResult result) {
		if (result.hasFieldErrors()) {
			return "redirect:/from";
		}
		clicRepository.save(cliente);
		return "redirect:/home";
	}
	
	// Acessa o formulario de edição
	@GetMapping("from/{id}")
	public String updateFrom(Model model, @PathVariable(name="id")int id) {
		Cliente cliente = clicRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid user id" + id));
		model.addAttribute("cliente", cliente);
		return "atualizaForm";
	}
	
	// Atualizar cliente
	@PostMapping("update/{id}")
	public String alterarDados(@Valid Cliente cliente, BindingResult result, @PathVariable int id) {
		if (result.hasErrors()) {
			return "redirect:/from";
		}
		clicRepository.save(cliente);
		return "redirect:/home";
	}
	
	// Deletar cliente
	@GetMapping("delete/{id}")
	@CacheEvict(value = "clientes", allEntries = true)
	public String delete(@PathVariable(name = "id") int id, Model model) {
		Cliente cliente = clicRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid user Id: " + id));
		clicRepository.delete(cliente);
		return "redirect:/home";
	}
		
}