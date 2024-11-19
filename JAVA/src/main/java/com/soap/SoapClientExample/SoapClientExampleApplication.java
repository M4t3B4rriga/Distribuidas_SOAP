package com.soap.SoapClientExample;

import com.soap.client.Client;
import com.soap.wsdl.AddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapClientExampleApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SoapClientExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SoapClientExampleApplication.class, args);
	}

//	@Bean
	CommandLineRunner init(Client client) {
		return args -> {
			AddResponse addResponse = client.getAddResponse(10, 20);
			LOGGER.info("El resultado de la suma es: {}", addResponse.getAddResult());
		};
	}
}