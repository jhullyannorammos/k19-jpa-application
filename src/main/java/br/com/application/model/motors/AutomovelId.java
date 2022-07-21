package br.com.application.model.motors;

import java.io.Serializable;

import javax.persistence.Embeddable;


//@Embeddable
public class AutomovelId implements Serializable {
	
	private String placa;
	private String cidade;
	
	public AutomovelId(String placa, String cidade) {
		this.cidade = cidade;
		this.placa = placa;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
