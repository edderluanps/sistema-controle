package com.eluanps.sistemacontrole.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class ServicosPrestados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 255)
	private String descricao;
	
	@OneToMany
	@JoinColumn(name = "id_cliente")
	@Transient
	private Cliente cliente;
	
	@Column
	private BigDecimal valor;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataServico;
	
	public ServicosPrestados() {
		
	}
	
	public ServicosPrestados(Integer id, String descricao, Cliente cliente, BigDecimal valor, LocalDate dataServico) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cliente = cliente;
		this.valor = valor;
		this.dataServico = dataServico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public LocalDate getDataServico() {
		return dataServico;
	}
	
	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
	}
	
}
