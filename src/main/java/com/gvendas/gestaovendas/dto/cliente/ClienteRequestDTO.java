package com.gvendas.gestaovendas.dto.cliente;

import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.entidades.Endereco;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente Requisição DTO")
public class ClienteRequestDTO {

	@ApiModelProperty(value = "Nome")
	private String nome;

	@ApiModelProperty(value = "Telefone")
	private String telefone;

	@ApiModelProperty(value = "Ativo")
	private Boolean ativo;

	@ApiModelProperty(value = "Endereço")
	private EnderecoRequestDTO enderecoDto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public EnderecoRequestDTO getEnderecoDto() {
		return enderecoDto;
	}

	public void setEnderecoDto(EnderecoRequestDTO enderecoDto) {
		this.enderecoDto = enderecoDto;
	}

	public Cliente converterParaEntidade() {
		Endereco endereco = new Endereco(enderecoDto.getLogradouro(), enderecoDto.getNumero(),
				enderecoDto.getComplemento(), enderecoDto.getBairro(), enderecoDto.getCep(), enderecoDto.getCidade(),
				enderecoDto.getEstado());
		return new Cliente(nome, telefone, ativo, endereco);
	}

}
