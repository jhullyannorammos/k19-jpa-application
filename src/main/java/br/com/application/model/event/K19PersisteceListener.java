package br.com.application.model.event;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class K19PersisteceListener {
	
	@PostPersist
	@PostUpdate
	@PostRemove
	@PrePersist
	@PreUpdate
	@PreRemove
	@PostLoad
	public String callback() {
		return "tratando todos os eventos: ...";
	}

}
