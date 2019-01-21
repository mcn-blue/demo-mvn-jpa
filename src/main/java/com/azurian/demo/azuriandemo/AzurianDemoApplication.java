package com.azurian.demo.azuriandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller 
@ComponentScan
@SpringBootApplication 
public class AzurianDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzurianDemoApplication.class, args);
	}

}
 
