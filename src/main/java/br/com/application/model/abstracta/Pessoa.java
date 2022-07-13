package br.com.application.model.abstracta;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Entity;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
}
