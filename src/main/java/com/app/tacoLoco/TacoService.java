package com.app.tacoLoco;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TacoService {

	private final Double veggieTacoPrice = 2.5;
	private final Double beefTacoPrice = 3.0;
	private final Double chickenTacoPrice = 3.0;
	private final Double chorizoTacoPrice = 3.5;

	private String discountTotalResponse = "Your total with a 20% discount is $";
	private String standardTotalResponse = "Your total is $";

  /** getTacoPrices method is used to check the string values in order and add tacoPrices to tacoPricesList */
	private String getTacoPrices(List<String> order) {

		List<Double> tacoPricesList = new ArrayList<>();

		  order
		    .stream()
		    .map(taco -> taco.toLowerCase().replaceAll("\\s+",""))
		    .forEach(t -> {

          switch (t) {
            case "veggietaco":
              tacoPricesList.add(veggieTacoPrice);
              break;
            case "beeftaco":
              tacoPricesList.add(beefTacoPrice);
              break;
            case "chickentaco":
      	      tacoPricesList.add(chickenTacoPrice);
              break;
            case "chorizotaco":
              tacoPricesList.add(chorizoTacoPrice);
              break;
            default:
            	throw new IllegalArgumentException(t + " is not a valid entry.. Please choose from the following options: Veggie Taco ($2.50), Beef Taco ($3.00), Chicken Taco ($3.00), Chorizo Taco ($3.50)");
         }

		  });

		return getOrderTotal(tacoPricesList);
	}

	/** getOrderTotal method is used to check the double values in orderPrices, calculate the total and return a response and total based on the size of orderPrices */
	private String getOrderTotal(List<Double> orderPrices) {

		double standardOrderTotal = orderPrices.stream().mapToDouble(i -> i.doubleValue()).sum();
		double discountOrderTotal;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");

	    if (orderPrices.size() > 3) {

	      double discount = (double) (standardOrderTotal * .20);
	      discountOrderTotal = standardOrderTotal - discount;

	      return discountTotalResponse + decimalFormat.format(discountOrderTotal);
	  }

      else  {

        return standardTotalResponse + decimalFormat.format(standardOrderTotal);
	  }

	}

  /** getUpdatedOrder method is used for retrieving the total price of a taco order */
	public String getUpdatedOrder(Taco tacos) {

		System.out.println(tacos.toString());
		
	  return getTacoPrices(tacos.getOrderItems());
	}

}
