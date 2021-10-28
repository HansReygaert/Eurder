package com.hansreygaert.switchfully.euder;

import com.hansreygaert.switchfully.euder.domain.Currency;
import com.hansreygaert.switchfully.euder.domain.entity.Price;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EuderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuderApplication.class, args);
		System.out.println(new Price(Currency.EURO,50.000223344).toString());
	}

}
