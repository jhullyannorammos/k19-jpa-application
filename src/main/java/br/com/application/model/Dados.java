package br.com.application.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

public class Dados implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	@Version private Long id;
	
	@Version private Long versao;
	@Version private Timestamp dataCriacao;
	@Version private Short tamanho = 102;

}
