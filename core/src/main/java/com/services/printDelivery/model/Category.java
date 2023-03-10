package com.services.printDelivery.model;

import javax.persistence.*;

@Entity
@Table
public class Category {

	@Id
	@SequenceGenerator(name = "categorySeq"  , sequenceName = "category_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY , generator = "categorySeq")
	private long id;

	private String code;

	private String title;
}
