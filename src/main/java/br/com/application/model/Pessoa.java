package br.com.application.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@NamedQueries ({
	@NamedQuery(name = "Pessoa.count", query = "SELECT COUNT (p) FROM Pessoa p"),
	@NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
})

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	@Lob private byte[] avatar;
	
	@Column(unique = true)
	private String email;
	
	@Column(length =30, nullable=false , unique=true)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar nascimento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataDeCadastro;
	
	@Transient private int idade;
	
	@Basic(fetch = FetchType.LAZY) @Column(precision =3, scale =2)
	private BigDecimal altura;
	
	@ElementCollection
	@CollectionTable(name="Telefone_pessoal", 
	                 joinColumns=@JoinColumn(name="pessoa_id"))
	@Column(name="telefone")
	private Collection<String> telefones;


}
