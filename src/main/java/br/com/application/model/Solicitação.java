package br.com.application.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.application.model.event.K19PersisteceListener;

@Entity
@EntityListeners(K19PersisteceListener.class)
public class Solicitação implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Comentario> comentarios;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataSolicitacao;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name= "cliente_id")
	private Cliente cliente;

}
