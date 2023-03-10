package com.services.printDelivery.model.business;

import com.services.printDelivery.model.BaseInformation;
import com.services.printDelivery.model.print.OrderLine;
import com.services.printDelivery.model.print.PrintOrder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "printing_office")
public class PrintingOffice extends Business {
	@Id
	@SequenceGenerator(name = "printingOfficeSeq", sequenceName = "printing_office_Seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "printingOfficeSeq")
	private long id;

	@OneToMany
	@JoinColumn(name = "printing_office", foreignKey = @ForeignKey(name = "bs_printing_fk_cons"))
	private List<BaseInformation> printerList;

	@OneToMany(mappedBy = "printingOffice")
	private List<OrderLine> orderLineList = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<BaseInformation> getPrinterList() {
		return printerList;
	}

	public void setPrinterList(List<BaseInformation> printerList) {
		this.printerList = printerList;
	}
}
