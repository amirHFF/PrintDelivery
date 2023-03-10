package com.services.printDelivery.model;

import javax.persistence.*;

@Table(name = "base_information")
@Entity
public class BaseInformation {

	@Id
	@SequenceGenerator( name = "baseInformationSeq" , sequenceName = "base_information_seq" , allocationSize = 1)
	@GeneratedValue(generator = "baseInformationSeq" , strategy =GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "categoryFk" )
	private Category category;

	@Column(name = "value")
	private String value;
}
