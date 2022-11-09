//package repository;

package Funtec.ProjetoBanco.model.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import Funtec.ProjetoBanco.model.Cliente;
import Funtec.ProjetoBanco.model.ClienteSetor;

//import funtec.projetoBanco.model.Cliente;
//import funtec.projetoBanco.model.ClienteSetor;

public interface ClienteRepository extends JpaRepository <Cliente,Integer> {
    List<Cliente> findBySetor(ClienteSetor clienteSetor);
}