package com.eluanps.sistemacontrole.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.eluanps.sistemacontrole.models.Cliente;
import com.eluanps.sistemacontrole.models.ServicosPrestados;
import com.eluanps.sistemacontrole.models.dto.ServicosPrestadosDTO;
import com.eluanps.sistemacontrole.repositories.ClienteRepository;
import com.eluanps.sistemacontrole.repositories.ServicosPrestadosRepository;
import com.eluanps.sistemacontrole.util.BigDecimalConverter;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicosPrestadosController {

    private ClienteRepository clienteRepository;
    private ServicosPrestadosRepository repository;
    private BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicosPrestados salvar(@RequestBody @Valid ServicosPrestadosDTO dto) {
        LocalDate data = LocalDate.parse(dto.getDataServico(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));

        ServicosPrestados servicoPrestado = new ServicosPrestados();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setDataServico(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return repository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicosPrestados> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
}
