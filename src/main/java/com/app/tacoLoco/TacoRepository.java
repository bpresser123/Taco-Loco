package com.app.tacoLoco;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.app.tacoLoco.Taco;

public interface TacoRepository extends CrudRepository<Taco, Integer> {
	
	List<Taco> findAll();

}