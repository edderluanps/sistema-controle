package com.eluanps.sistemacontrole.models.dto;

public class ServicosPrestadosDTO {
	
	private String descricao;
	private String preco;
	private String dataServico;
	private Integer IdCliente;
	
	public ServicosPrestadosDTO() {
	}

	public ServicosPrestadosDTO(String descricao, String preco, String dataServico, Integer idCliente) {
		this.descricao = descricao;
		this.preco = preco;
		this.dataServico = dataServico;
		IdCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDataServico() {
		return dataServico;
	}

	public void setDataServico(String dataServico) {
		this.dataServico = dataServico;
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}
	
	

}
