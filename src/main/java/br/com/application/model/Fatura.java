package br.com.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import org.hibernate.annotations.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Fatura implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection <Ligacao> ligacoes = new ArrayList<Ligacao>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar vencimento;

}
