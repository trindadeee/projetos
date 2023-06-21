package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
//a api so funcionou quando eu coloquei os construtores na classe endereco sem uso de anotação e quando eu 
	//coloquei a strategy de gerar o id como sequence
}
