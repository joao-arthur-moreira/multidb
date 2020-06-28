package br.com.jajm.multidb.model.db1;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Livro {
	
	@Id
	private Long codigo;
	
	private String nome;
	
	private String nomeUsuario;

}
