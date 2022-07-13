package br.com.application.model;

import java.io.Serializable;
import javax.persistence.*;


import javax.persistence.Entity;

@Entity
public class Categoria implements Serializable {
	
	 @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 @Column(name = "codigo")
	 private Long id;
	 
	 @Column(name="categoria")
	 private String descricao;

}
