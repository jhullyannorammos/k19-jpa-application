package br.com.application.model.motors;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Table(name = "acessorio")
@Entity
public class Acessorio {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	@ManyToMany(mappedBy = "acessorios")
	private Set<Automovel> veiculos = new HashSet<>();
	
	@Column(name = "acessorio")
	private String descricao;
	
	public Set<Automovel> getVeiculos() {
		return veiculos;
	}
	
	public void setVeiculos(Set<Automovel> veiculos) {
		this.veiculos = veiculos;
	}

    public Long getId() {
		return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 60, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
