package br.com.jajm.multidb.model.db2;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario {

	@Id
	private Long codigo;
	
	private String nome;
}
