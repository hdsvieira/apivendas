package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda Retorno DTO")
public class VendaResponseDTO {

	@ApiModelProperty(value = "Código")
	private Long codigo;

	@ApiModelProperty(value = "Data")
	private LocalDate data;

	@ApiModelProperty(value = "Itens da venda")
	private List<ItemVendaResponseDTO> itemVendaResponseDTOs;

	public VendaResponseDTO(Long codigo, LocalDate data, List<ItemVendaResponseDTO> itemVendaResponseDTOs) {
		this.codigo = codigo;
		this.data = data;
		this.itemVendaResponseDTOs = itemVendaResponseDTOs;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemVendaResponseDTO> getItemVendaResponseDTOs() {
		return itemVendaResponseDTOs;
	}

	public void setItemVendaResponseDTOs(List<ItemVendaResponseDTO> itemVendaResponseDTOs) {
		this.itemVendaResponseDTOs = itemVendaResponseDTOs;
	}

}
