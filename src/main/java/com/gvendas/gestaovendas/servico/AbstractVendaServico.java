package com.gvendas.gestaovendas.servico;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.ItemVendaResponseDTO;
import com.gvendas.gestaovendas.dto.venda.VendaResponseDTO;
import com.gvendas.gestaovendas.entidades.ItemVenda;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.entidades.Venda;

public abstract class AbstractVendaServico {

	protected VendaResponseDTO criandoVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {
		List<ItemVendaResponseDTO> itensVendaResponseDto = itensVendaList.stream()
				.map(this::criandoItensVendaResponseDTO).collect(Collectors.toList());
		return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itensVendaResponseDto);

	}

	protected ItemVendaResponseDTO criandoItensVendaResponseDTO(ItemVenda itemVenda) {
		return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
				itemVenda.getProduto().getCodigo(), itemVenda.getProduto().getDescricao());
	}

	protected ClienteVendaResponseDTO retornandoClienteVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {
		VendaResponseDTO vendaEncontrada = criandoVendaResponseDTO(venda, itensVendaList);
		return new ClienteVendaResponseDTO(venda.getCliente().getNome(), Arrays.asList(vendaEncontrada));
	}
	
	protected ItemVenda criandoItemVenda(ItemVendaRequestDTO itemVendaDto, Venda venda) {
		return new ItemVenda(new Produto(itemVendaDto.getCodigoProduto()), venda, itemVendaDto.getQuantidade(),
				itemVendaDto.getPrecoVendido());
	}
}
