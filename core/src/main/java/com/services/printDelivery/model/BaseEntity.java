package com.services.printDelivery.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "insert_time" , nullable = false)
	private LocalDateTime insertTime;
	@Column(name = "update_time" , nullable = false)
	private LocalDateTime updateTime;
	@Version
	@Column(nullable = false)
	private int version;

	public LocalDateTime getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(LocalDateTime insertTime) {
		this.insertTime = insertTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
