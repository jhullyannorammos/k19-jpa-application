package br.com.application.model.inheritance;



import org.hibernate.annotations.Entity;

import br.com.application.model.abstracta.ABSPessoa;

@Entity
public class PF extends ABSPessoa {
	private String cpf;
}
