package br.com.application.model.motors;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "modelos")
@Entity
public class Modelo implements Serializable{
	
	private Long id;
	
	//@Id @GeneratedValue(generator = "inc")
	//@GenericGenerator(name = "inc", strategy = "increment")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

}
