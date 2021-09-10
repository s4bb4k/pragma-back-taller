package com.co.app.cliente.application.port.in;

import com.co.app.cliente.domain.ClienteDto;

public interface ActualizarClienteUseCase {

    public ClienteDto actualizarCliente(ClienteDto clienteDto);

}
