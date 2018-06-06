package com.app.tacoLoco;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
    @ElementCollection(targetClass=String.class)
	private List<String> orderItems;

	public Taco() {

	}

	public Taco(String firstName, String lastName, List<String> orderItems) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.orderItems = orderItems;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<String> getOrderItems() {
		return orderItems;
	}

	@Override
	public String toString() {
		return "\n\nfirstName: " + firstName + "\nlastName: " + lastName + "\norderItems: " + orderItems + "\n";
	}

}
