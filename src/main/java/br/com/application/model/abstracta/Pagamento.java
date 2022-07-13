package br.com.application.model.abstracta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Entity;

@Entity
@Inheritance( strategy = InheritanceType.JOINED)
public class Pagamento {

	@Id @GeneratedValue
	private Long id;
	
	@Column() private BigDecimal valor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime vencimento;
}
