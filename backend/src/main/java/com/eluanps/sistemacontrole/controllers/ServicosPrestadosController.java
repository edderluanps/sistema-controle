package com.eluanps.sistemacontrole.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.eluanps.sistemacontrole.models.Cliente;
import com.eluanps.sistemacontrole.models.ServicosPrestados;
import com.eluanps.sistemacontrole.models.dto.ServicosPrestadosDTO;
import com.eluanps.sistemacontrole.repositories.ClienteRepository;
import com.eluanps.sistemacontrole.repositories.ServicosPrestadosRepository;
import com.eluanps.sistemacontrole.util.BigDecimalConverter;


@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicosPrestadosController {
	

	private final ClienteRepository clienteRepository;
	private final ServicosPrestadosRepository servicosPrestadosRepository;
	private final BigDecimalConverter bigDecimalConverter;
	
	public ServicosPrestadosController(ClienteRepository clienteRepository, ServicosPrestadosRepository servicosPrestadosRepository, BigDecimalConverter bigDecimalConverter) {
		this.clienteRepository = clienteRepository;
		this.servicosPrestadosRepository = servicosPrestadosRepository;
		this.bigDecimalConverter = bigDecimalConverter;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicosPrestados salvar(@RequestBody ServicosPrestadosDTO servicosPrestadosDTO) {
		
		Integer idCliente = servicosPrestadosDTO.getIdCliente();
		LocalDate dataF = LocalDate.parse(servicosPrestadosDTO.getDataServico(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));

		
		ServicosPrestados servicosPrestados = new ServicosPrestados();
		servicosPrestados.setDescricao(servicosPrestadosDTO.getDescricao());
		servicosPrestados.setDataServico(dataF);
		servicosPrestados.setCliente(cliente);
		servicosPrestados.setValor(bigDecimalConverter.converter(servicosPrestadosDTO.getPreco()));

		return servicosPrestadosRepository.save(servicosPrestados);
		
	}

}
