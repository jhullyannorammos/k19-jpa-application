package br.com.application.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Solicitação implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	private List<Comentario> comentarios;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataSolicitacao;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name= "cliente_id")
	private Cliente cliente;

}
