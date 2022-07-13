package br.com.application.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String complemento;
	private String logradouro;
	private int numero;
	private int cep;
	private String cidade;
	private String estado;
	private String pais;
}
