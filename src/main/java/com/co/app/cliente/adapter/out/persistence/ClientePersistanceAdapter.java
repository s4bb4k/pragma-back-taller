package com.co.app.cliente.adapter.out.persistence;

import com.co.app.cliente.application.port.out.ClienteQuery;
import com.co.app.cliente.domain.ClienteDto;
import com.co.app.miscellaneous.utils.Constante;
import com.co.app.miscellaneous.utils.MessageExceptionUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class ClientePersistanceAdapter implements ClienteQuery {

    private final MessageExceptionUtil messageExceptionDtoUtil;
    private final ClienteRepositoryJpa clienteRepositoryJpa;

    @Autowired
    public ClientePersistanceAdapter(ClienteRepositoryJpa clienteRepositoryJpa,
                                     MessageExceptionUtil messageExceptionDtoUtil) {
        this.messageExceptionDtoUtil = messageExceptionDtoUtil;
        this.clienteRepositoryJpa = clienteRepositoryJpa;
    }

    @Override
    public List<ClienteDto> getCliente() {
        log.info("[{}]- consultando getCliente, message{}..", Thread.currentThread().getId());
        List<ClienteDto> cliente = null;
        try{
            cliente = clienteRepositoryJpa.obtenerCliente();
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ClienteDto> getClienteById(Integer id) {
        log.info("[{}]- consultando getClienteById, message{}..", Thread.currentThread().getId());
        List<ClienteDto> cliente = null;
        try{
            cliente = clienteRepositoryJpa.obtenerClienteById(id);
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public ClienteDto crearCliente(ClienteDto clienteDto) {

        Integer seqClientes = clienteRepositoryJpa.getNextValSequence();
        clienteDto.setId(seqClientes);

        clienteRepositoryJpa.crearCliente(
                clienteDto.getId(),
                clienteDto.getNombre(),
                clienteDto.getApellido(),
                clienteDto.getFechanacimiento(),
                clienteDto.getIdciudad(),
                clienteDto.getIdtipodocumento(),
                clienteDto.getIdimagen(),
                clienteDto.getEstado()
        );

        return clienteDto;
    }

    @Transactional
    @Override
    public Integer actualizarCliente(ClienteDto clienteDto) {

        System.out.println("----------------------------------------------------------------------------->");
        System.out.println("cliente: " + clienteDto);
        System.out.println("----------------------------------------------------------------------------->");

        return clienteRepositoryJpa.actualizarCliente(
                clienteDto.getNombre(),
                clienteDto.getApellido(),
                clienteDto.getFechanacimiento(),
                clienteDto.getIdciudad(),
                clienteDto.getIdtipodocumento(),
                clienteDto.getIdimagen(),
                clienteDto.getId()
        );
    }

    @Transactional
    @Override
    public Integer actualizarEstadoCliente(String estado, Integer idCliente) {
        return clienteRepositoryJpa.actualizarEstadoCliente(Constante.ESTADO_INACTIVO, idCliente);
    }

}
