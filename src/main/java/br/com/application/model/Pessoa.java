package br.com.application.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_pessoas")
public class Pessoa implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_cargo")
	private Long id;
	
	@Lob private byte[] avatar;
	
	@Column(unique = true)
	private String email;
	
	@Column(length =30, nullable=false , unique=true)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar nascimento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataDeCadastro ;
	
	@Transient private int idade;
	
	@Column(precision =3, scale =2)
	private BigDecimal altura;
	
	@ElementCollection
	@CollectionTable(name="Telefone_pessoal", 
	                 joinColumns=@JoinColumn(name="pessoa_id"))
	@Column(name="telefone")
	private Collection<String> telefones;

}
