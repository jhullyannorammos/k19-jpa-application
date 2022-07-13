package br.com.application.model.inheritance;

import javax.persistence.Column;

import org.hibernate.annotations.Entity;

import br.com.application.model.abstracta.Pagamento;

@Entity
public class Pix extends Pagamento {
	
	@Column() private String key;

}
