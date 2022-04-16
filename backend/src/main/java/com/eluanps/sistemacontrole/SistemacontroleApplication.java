package com.eluanps.sistemacontrole;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eluanps.sistemacontrole.models.Cliente;
import com.eluanps.sistemacontrole.repositories.ClienteRepository;

@SpringBootApplication
public class SistemacontroleApplication {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Bean
	public CommandLineRunner run() {
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Fulano");
			cliente.setCpf("00000000000");
			cliente.setDataCadastro(LocalDate.now());
			clienteRepository.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemacontroleApplication.class, args);
	}

}
