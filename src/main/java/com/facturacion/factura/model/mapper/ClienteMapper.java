package com.facturacion.factura.model.mapper;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.model.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente dtoToCliente(ClienteDto clienteDto);

    ClienteDto clienteToDto(Cliente cliente);

     List<Cliente> dtoToCliente(List<ClienteDto> clienteDtos);

    List<ClienteDto> clienteToDto(List<Cliente> clientes);
}
