package br.com.julliafernandes.todolist;

import org.springframework.boot.SpringApplication; //1
import org.springframework.boot.autoconfigure.SpringBootApplication; //2

@SpringBootApplication //Quem vai executar minha aplicação e para conseguir usa-lo preciso importar ele de algum lugar, importei do 2 utilizano a classe SpringBootAplication 
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
