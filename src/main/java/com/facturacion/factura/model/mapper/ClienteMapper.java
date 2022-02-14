package com.facturacion.factura.model.mapper;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.model.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    @Mappings({
            @Mapping(source = "clienteId", target = "clienteId"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "direccion", target = "direccion"),
            @Mapping(source = "telefono", target = "telefono"),
            @Mapping(source = "estado", target = "estado"),
            @Mapping(source = "fecha", target = "fecha"),
    })
    ClienteDto toClienteDto(Cliente cliente);

    List<ClienteDto> toClienteDto(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente (ClienteDto clienteDto);

     List<Cliente> toCliente(List<ClienteDto> clienteDtos);


}
