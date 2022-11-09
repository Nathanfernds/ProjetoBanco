package Funtec.ProjetoBanco.model;

import java.math.BigDecimal;
//import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String agencia;
    private BigDecimal salario;
    private String TipoDeConta;

    @Enumerated(EnumType.STRING)
    private ClienteSetor setor;

    
    public void setSetor(ClienteSetor setor) {
    	this.setor = setor;
    
   
}

}