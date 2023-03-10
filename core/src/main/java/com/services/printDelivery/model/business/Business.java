package com.services.printDelivery.model.business;

import com.services.printDelivery.model.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class Business extends BaseEntity {

	@Column(name = "business_name", nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Status status;

	@Column(name = "business_identity", nullable = false)
	private String businessIdentity;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "business_fk", nullable = false)
	private List<Phone> phone = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_fk", foreignKey = @ForeignKey(name = "business_address_fk_const"), nullable = false)
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getBusinessIdentity() {
		return businessIdentity;
	}

	public void setBusinessIdentity(String businessIdentity) {
		this.businessIdentity = businessIdentity;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
