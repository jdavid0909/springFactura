package com.facturacion.factura.service;


import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Factura;

import java.util.ArrayList;
import java.util.List;

public interface FacturaService {

    List<FacturaDto> buscarFacturas(Integer id);
}
