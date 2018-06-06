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

	private TacoRepository tacoRepository;
	private TacoService tacoService;

	public TacoController(TacoService tacoService, TacoRepository tacoRepository) {

		this.tacoService = tacoService;
		this.tacoRepository = tacoRepository;
	}


  /** addOrder method is used to POST a new taco order and checks if the order is empty */
	@PostMapping("/placeOrder")
	public Object addOrder(@RequestBody Taco tacos) {

    if (tacos.getOrderItems().isEmpty()) {

			throw new IllegalArgumentException("Your order is empty..");
		}

		System.out.println("Customer: " + tacos.getFirstName() + " " + tacos.getLastName());
		tacoRepository.save(tacos);

		String stringResponse = tacos.getFirstName() + " " + tacos.getLastName() + ": " + tacoService.getUpdatedOrder(tacos) + "\n" + tacoRepository.findAll() + "\n";
		return stringResponse;
	}

  /** handleIllegalArgumentException method is used to return a 400 Bad Request error when an item in a taco order is invalid */
	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {

	  response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

}
