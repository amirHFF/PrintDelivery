package com.services.printDelivery.model.business;

import com.services.printDelivery.model.Person;

import javax.persistence.*;

@Table(name = "client_business")
@Entity
public class ClientBusiness extends Business {

	@Id
	@SequenceGenerator(name = "clientBusinessSeq" , sequenceName = "client_business_seq" , allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.IDENTITY , generator = "clientBusinessSeq" )
	private long id;

	@OneToOne
	@JoinColumn(name = "person_fk" , foreignKey = @ForeignKey(name = "client_business_person_fk_cons") ,nullable = false)
	private Person supervisor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Person supervisor) {
		this.supervisor = supervisor;
	}
}
