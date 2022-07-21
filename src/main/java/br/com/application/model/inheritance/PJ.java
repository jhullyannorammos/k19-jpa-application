package br.com.application.model.inheritance;

import org.hibernate.annotations.Entity;

import br.com.application.model.abstracta.ABSPessoa;


@Entity
public class PJ extends ABSPessoa {
	private String cnpj ;
}
