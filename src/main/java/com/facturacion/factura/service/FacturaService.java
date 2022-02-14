package com.facturacion.factura.service;


import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Factura;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FacturaService {

    List<FacturaDto> buscarFacturas(Integer id);
    Page<FacturaDto> buscarFacturasFechas(Date fechaInicio, Date fechaFin , int page, int size, String[] sort);
}
