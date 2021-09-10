package com.co.app.cliente.application.port.out;

import com.co.app.cliente.domain.ClienteDto;

import java.util.List;

public interface ClienteQuery {

    public List<ClienteDto> getCliente();

    public List<ClienteDto> getClienteById(Integer id);

    public ClienteDto crearCliente(ClienteDto clienteDto);

    public int actualizarCliente(ClienteDto clienteDto);

    public Integer actualizarEstadoCliente(String estado, Integer idcliente);

}
