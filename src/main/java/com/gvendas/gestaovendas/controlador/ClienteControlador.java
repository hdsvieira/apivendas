package com.gvendas.gestaovendas.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.cliente.ClienteRequestDTO;
import com.gvendas.gestaovendas.dto.cliente.ClienteResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.servico.ClienteServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private ClienteServico clienteServico;

	@ApiOperation(value = "Listar", nickname = "listarTodosClientes")
	@GetMapping
	public List<ClienteResponseDTO> listarTodos() {
		return clienteServico.listarTodos().stream().map(cliente -> ClienteResponseDTO.convertParaClienteDTO(cliente))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Listar por código", nickname = "buscarClientePorId")
	@GetMapping("/{codigo}")
	public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable(name = "codigo") Long codigo) {
		Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigo);
		return cliente.isPresent() ? ResponseEntity.ok(ClienteResponseDTO.convertParaClienteDTO(cliente.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar", nickname = "salvarCliente")
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteDto) {
		Cliente clienteSalvo = clienteServico.salvar(clienteDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponseDTO.convertParaClienteDTO(clienteSalvo));
	}

}