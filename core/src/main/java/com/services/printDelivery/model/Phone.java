package com.services.printDelivery.model;

import com.services.printDelivery.model.business.Business;
import com.services.printDelivery.model.business.ClientBusiness;
import com.services.printDelivery.model.business.PrintingOffice;

import javax.persistence.*;

@Table
@Entity
public class Phone {
	@Id
	@SequenceGenerator( name = "phoneSeq" , sequenceName = "phone_seq" , allocationSize = 1)
	@GeneratedValue(generator = "phoneSeq" , strategy =GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private PhoneType phoneType;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

}
