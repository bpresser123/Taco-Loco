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
    @ElementCollection(targetClass=String.class)
	private List<String> orderItems;

	@Column
	private String firstName;

	@Column
	private String lastName;

	public Taco() {

	}

	public Taco(List<String> orderItems, String firstName, String lastName) {
		this.orderItems = orderItems;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<String> getOrderItems() {
		return orderItems;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "\nfirstName: " + firstName + "\nlastName: " + lastName + "\norderItems: " + orderItems + "\n";
	}

}
