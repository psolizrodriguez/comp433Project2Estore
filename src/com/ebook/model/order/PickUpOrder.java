package com.ebook.model.order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ebook.model.customer.Address;

@Entity
public class PickUpOrder extends CustomerOrder {
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Address pickUpAddress;
	private String initialTime;
	private String finalTime;

	public String getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(String initialTime) {
		this.initialTime = initialTime;
	}

	public String getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(String finalTime) {
		this.finalTime = finalTime;
	}

	public Address getPickUpAddress() {
		return pickUpAddress;
	}

	public void setPickUpAddress(Address pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}

}
