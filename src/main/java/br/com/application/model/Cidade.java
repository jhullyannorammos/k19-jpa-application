package br.com.application.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Cacheable(true)
public class Cidade implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	private String nome;

}
