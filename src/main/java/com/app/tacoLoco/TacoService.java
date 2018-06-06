package com.app.tacoLoco;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TacoService {

	@Value("#{'${tacoPrices}'.split(',')}")
	private List<Double> tacoPrices;

	@Value("${discountTotalResponse}")
	private String discountTotalResponse;

	@Value("${standardTotalResponse}")
	private String standardTotalResponse;

  /** getTacoPrices method is used to check the string values in order and add tacoPrices to tacoPricesList */
	private String getTacoPrices(List<String> order) {

		List<Double> tacoPricesList = new ArrayList<>();

		while (true) {

		  order
		    .stream()
		    .map(taco -> taco.toLowerCase().replaceAll("\\s+",""))
		    .forEach(t -> {

          switch (t) {
            case "veggietaco":
              tacoPricesList.add(this.tacoPrices.get(0));
              break;
            case "beeftaco":
              tacoPricesList.add(this.tacoPrices.get(1));
              break;
            case "chickentaco":
      	      tacoPricesList.add(this.tacoPrices.get(2));
              break;
            case "chorizotaco":
              tacoPricesList.add(this.tacoPrices.get(3));
              break;
            default:
            	throw new IllegalArgumentException(t + " is not a valid entry.. Please choose from the following options: Veggie Taco ($2.50), Beef Taco ($3.00), Chicken Taco ($3.00), Chorizo Taco ($3.50)");
         }

		  });

		  return getOrderTotal(tacoPricesList);
	  }
	}

	/** getOrderTotal method is used to check the double values in orderPrices, calculate the total and return a response and total based on the size of orderPrices */
	private String getOrderTotal(List<Double> orderPrices) {

		double standardOrderTotal = orderPrices.stream().mapToDouble(i -> i.doubleValue()).sum();
		double discountOrderTotal;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");

	    if (orderPrices.size() > 3) {

	      double discount = (double) (standardOrderTotal * .20);
	      discountOrderTotal = standardOrderTotal - discount;

	      return this.discountTotalResponse + decimalFormat.format(discountOrderTotal);
	  }

      else  {

        return this.standardTotalResponse + decimalFormat.format(standardOrderTotal);
	  }

	}

  /** getUpdatedOrder method is used for retrieving the total price of a taco order */
	public String getUpdatedOrder(Taco tacos) {

	  return getTacoPrices(tacos.getOrderItems());
	}

}
