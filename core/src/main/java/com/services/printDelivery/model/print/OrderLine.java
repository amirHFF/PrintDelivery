package com.services.printDelivery.model.print;

import com.services.printDelivery.model.BaseEntity;
import com.services.printDelivery.model.BaseInformation;
import com.services.printDelivery.model.business.PrintingOffice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Order_Line")
public class OrderLine extends BaseEntity {
	@Id
	@SequenceGenerator(name = "orderLineSeq" , sequenceName = "order_Line_Seq" ,allocationSize = 1)
	@GeneratedValue(generator = "orderLineSeq" , strategy = GenerationType.SEQUENCE)
	private long id;

	private boolean isActive;

	@OneToOne
	@JoinColumn(name = "printer_id" ,foreignKey = @ForeignKey(name = "bs_Order_Line_fk_cons"))
	private BaseInformation printer;

	@OneToMany(mappedBy = "orderLine" )
	private List<Request> requestList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "printing_office_fk" , foreignKey = @ForeignKey(name = "Order_Line_printing_office_seq_cons"))
	private PrintingOffice printingOffice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public BaseInformation getPrinter() {
		return printer;
	}

	public void setPrinter(BaseInformation printer) {
		this.printer = printer;
	}

	public List<Request> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<Request> requestList) {
		this.requestList = requestList;
	}
}
