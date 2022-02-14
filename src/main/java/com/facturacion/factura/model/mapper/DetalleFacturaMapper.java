package com.facturacion.factura.model.mapper;

import com.facturacion.factura.dto.DetalleFacturaDto;
import com.facturacion.factura.model.DetalleFactura;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DetalleFacturaMapper {

      DetalleFactura dtoToDetalleFactura(DetalleFacturaDto detalleFacturaDto);

    DetalleFacturaDto detalleFacturaToDto(DetalleFactura detalleFactura);

    List<DetalleFactura> dtoToDetalleFactura(List<DetalleFacturaDto> detalleFacturaDtos);

    List<DetalleFacturaDto> facturaDetalleToDto(List<DetalleFactura> facturas);
}
