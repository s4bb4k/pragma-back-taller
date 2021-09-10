package com.co.app.cliente.adapter.in.web;

import com.co.app.cliente.application.port.in.ActualizarClienteUseCase;
import com.co.app.cliente.application.port.in.CrearClienteUseCase;
import com.co.app.cliente.application.port.out.ClienteQuery;
import com.co.app.cliente.domain.ClienteDto;
import com.co.app.miscellaneous.dto.GenericDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@Api(value = "Operaciones pertinentes a clientes")
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteQuery clienteQuery;
    private final CrearClienteUseCase crearClienteUseCase;
    private final ActualizarClienteUseCase actualizarClienteUseCase;

    @Autowired
    public ClienteController(ClienteQuery clienteQuery, CrearClienteUseCase crearClienteUseCase, ActualizarClienteUseCase actualizarClienteUseCase) {
        this.clienteQuery = clienteQuery;
        this.crearClienteUseCase = crearClienteUseCase;
        this.actualizarClienteUseCase = actualizarClienteUseCase;
    }

    @ApiOperation(value = "Listado de clientes", response = GenericDto.class)
    @GetMapping("/getCliente")
    public ResponseEntity<GenericDto> obtenerCliente() {
        log.info("[{}]- consultando cliente, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(clienteQuery.getCliente()));
    }
    
    @ApiOperation(value = "Creación de un cliente", response = GenericDto.class)
    @PostMapping("/crearCliente")
    public ResponseEntity<GenericDto> crearCliente(@RequestBody ClienteDto clienteDto) {
        log.info("[{}]- Crear Cliente, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(crearClienteUseCase.crearCliente(clienteDto)));
    }
    
    @ApiOperation(value = "Editar un Cliente", response = GenericDto.class)
    @PostMapping("/actualizarCliente")
    public ResponseEntity<GenericDto> actualizarCliente(@RequestBody ClienteDto clienteDto) {
        log.info("[{}]- Editar Cliente, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(actualizarClienteUseCase.actualizarCliente(clienteDto)));
    }

    /*@ApiOperation(value = "Actualización del estado del cliente", response = GenericDto.class)
    @PostMapping("/actualizarEstadoCliente/{id_cliente}")
    public ResponseEntity<GenericDto> actualizarEstadoCliente( @PathVariable("id_cliente") Integer idCliente) {
        log.info("[{}]- Actualizar estado del cliente, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(actualizarEstadoClienteUseCase.actualizarEstadoCliente(idCliente)));
    }*/

}
