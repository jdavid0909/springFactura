package com.facturacion.factura.model.mapper;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ClienteMapper.class})
public interface FacturaMapper {

    @Mappings({
            @Mapping(source = "invoiceId", target = "invoiceId"),
            @Mapping(source = "invoiceCode", target = "invoiceCode"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "cliente", target = "cliente")
    })
    FacturaDto toFacturaDto(Factura factura);
    List<FacturaDto> toFacturaDto(List<Factura> facturaDtos);

    @InheritInverseConfiguration
    Factura toFactura(FacturaDto facturaDto);


  //  Factura dtoToFactura(FacturaDto facturaDto);

   // FacturaDto facturaToDto(Factura factura);

   // List<Factura> dtoToFactura(List<FacturaDto> facturaDtos);

   // List<FacturaDto> facturaToDto(List<Factura> facturas);
}
