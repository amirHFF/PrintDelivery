package com.services.printDelivery.model.print;

import com.services.printDelivery.model.Address;
import com.services.printDelivery.model.BaseEntity;
import com.services.printDelivery.model.business.PrintingOffice;

import javax.persistence.*;

@Entity
@Table(name = "print_order")
public class PrintOrder extends BaseEntity {
	@Id
	@SequenceGenerator(name = "printerOrderSeq" , sequenceName = "printer_order_seq" ,allocationSize = 1)
	@GeneratedValue(generator = "printerOrderSeq" , strategy = GenerationType.SEQUENCE)
	private long id;

	private String printName;

	private long price;

	private float discount;

	private int count;

	private boolean isPayed;

	@ManyToOne
	@JoinColumn(name = "request_fk" , foreignKey = @ForeignKey(name = "print_order_request_fk_cons"))
	private Request request;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_fk" ,foreignKey = @ForeignKey(name = "print_order_address_fk_cons"))
	private Address receiverAddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrintName() {
		return printName;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isPayed() {
		return isPayed;
	}

	public void setPayed(boolean payed) {
		isPayed = payed;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Address getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(Address receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
}
