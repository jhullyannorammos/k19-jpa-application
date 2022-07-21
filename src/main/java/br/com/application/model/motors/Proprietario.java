package br.com.application.model.motors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;

@Entity
public class Proprietario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;

	@OneToMany(mappedBy = "proprietario")
	private List<Automovel> veiculos;

	private String nome;
	private List<String> telefones = new ArrayList<>();

	private List<Endereco> enderecos = new ArrayList<>();
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Automovel> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Automovel> veiculos) {
		this.veiculos = veiculos;
	}

	@Column(name = "nome_proprietario", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email_proprietario")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ElementCollection
	@CollectionTable(name = "proprietario_telefones", joinColumns = @JoinColumn(name = "cod_proprietario"))
	@Column(name = "numero_telefone", length = 20, nullable = false)
	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	@ElementCollection
	@CollectionTable(name = "proprietario_enderecos", joinColumns = @JoinColumn(name = "cod_proprietario"))
	@AttributeOverrides({
	     @AttributeOverride(name = "endereco", 
	     column = @Column(name = "num_endereco", length = 20, nullable = false)) 
	})
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
