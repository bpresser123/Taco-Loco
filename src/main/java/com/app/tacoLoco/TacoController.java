package com.app.tacoLoco;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TacoController {

	private TacoService tacoService;

	public TacoController(TacoService tacoService) {

    this.tacoService = tacoService;
	}

  /** addOrder method is used to POST a new taco order and checks if the order is empty */
	@PostMapping("/placeOrder")
	public Object addOrder(@RequestBody Taco tacos) {

    if (tacos.getOrderItems().isEmpty()) {

			throw new IllegalArgumentException("Your order is empty..");
		}

		return tacoService.getUpdatedOrder(tacos);
	}

  /** handleIllegalArgumentException method is used to return a 400 Bad Request error when an item in a taco order is invalid */
	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {

	  response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

}
