package com.services.printDelivery.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Person extends BaseEntity {

	@Id
	@SequenceGenerator(name = "personSeq", sequenceName = "Person_seq", allocationSize = 1)
	@GeneratedValue(generator = "personSeq", strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastFamily;

	@Column(name = "national_code", nullable = false)
	private String nationalCode;

	@Column(name = "father_name", nullable = false)
	private String fatherName;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_fk", foreignKey = @ForeignKey(name = "person_address_fk_cons"))
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "person_fk", foreignKey = @ForeignKey(name = "phone_address_fk_cons") , nullable = false)
	private List<Phone> phoneList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastFamily() {
		return lastFamily;
	}

	public void setLastFamily(String lastFamily) {
		this.lastFamily = lastFamily;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
}
