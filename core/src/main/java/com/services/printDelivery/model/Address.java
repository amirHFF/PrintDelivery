package com.services.printDelivery.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class Address extends BaseEntity {

	@Id
	@SequenceGenerator(name = "addressSeq" , sequenceName = "address_seq" , allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.IDENTITY , generator = "addressSeq" )
	private long id;

	@NotNull
	@OneToOne
	@JoinColumn( name = "city_fk", foreignKey =@ForeignKey(name ="address_base_information_city_fk_cons"),nullable = false)
	private BaseInformation city;

	@NotNull
	@OneToOne
	@JoinColumn( name = "province_fk", foreignKey =@ForeignKey(name ="address_base_information_province_fk_cons"))
	private BaseInformation province;

	@NotNull
	@Column(name = "address" , nullable = false)
	private String address;

	@Column
	private String postalCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BaseInformation getCity() {
		return city;
	}

	public void setCity(BaseInformation city) {
		this.city = city;
	}

	public BaseInformation getProvince() {
		return province;
	}

	public void setProvince(BaseInformation province) {
		this.province = province;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
