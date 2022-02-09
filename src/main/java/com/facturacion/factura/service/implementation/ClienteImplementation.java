package com.facturacion.factura.service.implementation;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import com.facturacion.factura.model.mapper.ClienteMapper;
import com.facturacion.factura.repository.ClienteRepository;
import com.facturacion.factura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteImplementation implements ClienteService {
    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDto> buscarFacturas(Integer id) {
        List<ClienteDto> clienteDtos;
        clienteDtos = clienteMapper
                .clienteToDto(clienteRepository.findByClienteId(id));
        return  new ArrayList<>(clienteDtos);

    }
}
