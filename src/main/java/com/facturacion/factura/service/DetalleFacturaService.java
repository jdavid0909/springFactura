package com.facturacion.factura.service;

import com.facturacion.factura.dto.DetalleFacturaDto;
import org.springframework.data.domain.Page;

public interface DetalleFacturaService {

    DetalleFacturaDto guardarDetalle(DetalleFacturaDto detalleFacturaDto);
}
