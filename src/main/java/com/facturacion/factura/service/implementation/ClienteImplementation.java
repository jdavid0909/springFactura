package com.facturacion.factura.service.implementation;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import com.facturacion.factura.model.mapper.ClienteMapper;
import com.facturacion.factura.repository.ClienteRepository;
import com.facturacion.factura.service.ClienteService;
import com.facturacion.factura.utils.SortingPagingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteImplementation implements ClienteService {
    @Autowired
    private final SortingPagingUtils sortingPagingUtils;

    @Autowired
    private final ClienteMapper clienteMapper;

    @Autowired
    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteDto> getAllEmployees( Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        List<ClienteDto> clienteDtos;
        clienteDtos = clienteMapper.toClienteDto(clienteRepository.findAll(paging).toList());

        return clienteDtos;
    }

    @Override
    public Page<ClienteDto> findPaginatedSortedCustomer(Integer clienteId, int page, int size, String[] sort) {

        List<Sort.Order> orders = sortingPagingUtils.getSortOrders(sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(orders));
        List<ClienteDto> customerDto;

        if(clienteId == 0){
            customerDto = clienteMapper.toClienteDto(clienteRepository.findAll(pageable).toList());

        } else {
            customerDto = clienteMapper.toClienteDto(clienteRepository.findByClienteId(clienteId,pageable).toList());
        }
        return new PageImpl<>(customerDto);
    }


    @Override
    public ClienteDto save(ClienteDto clienteDto){
        Cliente cliente = clienteMapper.toCliente(clienteDto);
        clienteRepository.save(cliente);
        return clienteMapper.toClienteDto(cliente);

    }

}
