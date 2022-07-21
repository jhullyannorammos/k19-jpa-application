package br.com.application.model.inheritance;



import javax.persistence.Entity;

import br.com.application.model.abstracta.ABSPessoa;


@Entity
public class PJ extends ABSPessoa {
	private String cnpj ;
}
