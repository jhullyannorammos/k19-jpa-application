package br.com.application.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity 
public class Produto implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;
    
    public Long getId() {
		return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    @PostLoad public String postLoad() {
    	return "um objeto foi carregado na database";
    }
    
    @PrePersist
    public String prePersist() {
    	return "Persistindo um novo objeto com persist ou merge";
    }
    
    @PostPersist
    public String postPersist() {
    	return "command insert executado na database, um rollback ainda pode desfazer esse comando";
    }
    
    @PreUpdate public String preUpdate() {
        return "edita objeto gerenciado com remove()";	
    }
    
    @PostUpdate public String postUpdate() {
		return "command update executado na database, um rollback ainda pode desfazer esse comando";
    }
    
    @PreRemove public String preRemove() {
        return "remove objeto gerenciado com remove()";	
    }
    
    @PostRemove public String postRemove() {
		return "command delete executado na database, um rollback ainda pode desfazer esse comando";
    }
}
