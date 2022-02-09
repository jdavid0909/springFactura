package com.facturacion.factura.model.mapper;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturaMapper {

    Factura dtoToFactura(FacturaDto facturaDto);

    FacturaDto facturaToDto(Factura factura);

    List<Factura> dtoToFactura(List<FacturaDto> facturaDtos);

    List<FacturaDto> facturaToDto(List<Factura> facturas);
}
