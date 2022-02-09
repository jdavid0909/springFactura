package com.facturacion.factura.service;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;

import java.util.List;

public interface ClienteService {

    List<ClienteDto> buscarFacturas(Integer id);
}
