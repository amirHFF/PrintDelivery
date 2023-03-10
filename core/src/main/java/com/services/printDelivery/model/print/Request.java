package com.services.printDelivery.model.print;

import com.services.printDelivery.model.BaseEntity;
import com.services.printDelivery.model.Person;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Request extends BaseEntity {
	@Id
	@SequenceGenerator(name = "requestSeq", sequenceName = "request_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestSeq")
	private long id;

	private LocalDateTime requestTime;

	private LocalDateTime deliveredTime;

	private LocalDateTime printedTime;

	private String requestId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "requester", foreignKey = @ForeignKey(name = "requester_person_fk_cons"))
	private Person requester;

	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true , mappedBy = "request" , fetch = FetchType.EAGER)
	private List<PrintOrder> printOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_line_fk" , foreignKey = @ForeignKey(name = "request_order_line_fk_cons"))
	private OrderLine orderLine;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	public LocalDateTime getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(LocalDateTime deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public LocalDateTime getPrintedTime() {
		return printedTime;
	}

	public void setPrintedTime(LocalDateTime printedTime) {
		this.printedTime = printedTime;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Person getRequester() {
		return requester;
	}

	public void setRequester(Person requester) {
		this.requester = requester;
	}

	public List<PrintOrder> getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(List<PrintOrder> printOrder) {
		this.printOrder = printOrder;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}
}
