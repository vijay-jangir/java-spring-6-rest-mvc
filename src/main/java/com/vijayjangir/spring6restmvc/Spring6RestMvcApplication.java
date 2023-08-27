package com.vijayjangir.spring6restmvc;

import com.vijayjangir.spring6restmvc.models.Beer;
import com.vijayjangir.spring6restmvc.services.BeerService;
import com.vijayjangir.spring6restmvc.services.BeerServiceImpl;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring6RestMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6RestMvcApplication.class, args);
//		BeerService impl = new BeerServiceImpl();
//		Beer beer = impl.getBeerId(UUID.randomUUID());
//		if (beer == impl.getBeerId(UUID.randomUUID())) {
//			System.out.println("something is wrong");
//		}
//		System.out.println(beer.toString());
	}


}
