package com.facturacion.factura.service;

import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.dto.ProductoDto;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface ProductoService {

    Page<ProductoDto> buscarConcidencias(String nombre, int page, int size, String[] sort);
}
