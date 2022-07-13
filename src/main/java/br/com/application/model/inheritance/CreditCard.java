package br.com.application.model.inheritance;

import javax.persistence.Column;

import org.hibernate.annotations.Entity;

import br.com.application.model.abstracta.Pagamento;

@Entity
public class CreditCard extends Pagamento {
	
	@Column() private String validade;
	@Column() private String titular;
	@Column() private String serial;
	@Column() private String code;

}
