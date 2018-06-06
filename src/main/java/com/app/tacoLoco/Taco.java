package com.app.tacoLoco;

import java.util.List;

public class Taco {


	private List<String> orderItems;

	public Taco() {

	}

	public Taco(List<String> orderItems) {
		this.orderItems = orderItems;
	}

	public List<String> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<String> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Taco [orderItems=" + orderItems + "]";
	}


}
