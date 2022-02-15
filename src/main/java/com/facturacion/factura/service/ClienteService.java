package com.facturacion.factura.service;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public interface ClienteService {

  /*  List<ClienteDto> buscarFacturas(Integer id);*/
   // Page<ClienteDto> getAllClienteFacturas(Integer id, int pageNo, int pageSize, String[] sort);
 // Page<ClienteDto> findPaginatedSortedCustomer(Integer customerId, int page, int size);
  Page<ClienteDto> findPaginatedSortedCustomer(Integer clienteId, int page, int size, String[] sort);
  List<ClienteDto> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);

  ClienteDto save(ClienteDto clienteDto);


}
