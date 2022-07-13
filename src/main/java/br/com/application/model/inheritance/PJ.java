package br.com.application.model.inheritance;

import org.hibernate.annotations.Entity;

import br.com.application.model.abstracta.Pessoa;

@Entity
public class PJ extends Pessoa {
	private String cnpj ;
}
