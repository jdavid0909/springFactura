package com.facturacion.factura.service.implementation;

import com.facturacion.factura.dto.DetalleFacturaDto;
import com.facturacion.factura.model.DetalleFactura;
import com.facturacion.factura.model.mapper.DetalleFacturaMapper;
import com.facturacion.factura.repository.DetalleFacturaRepository;
import com.facturacion.factura.service.DetalleFacturaService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaImplementation implements DetalleFacturaService {

    private DetalleFacturaMapper detalleFacturaMapper;

    private DetalleFacturaRepository detalleFacturaRepository;


    @Override
    public DetalleFacturaDto guardarDetalle(DetalleFacturaDto detalleFacturaDto) {
        DetalleFactura detalleFactura = detalleFacturaMapper.dtoToDetalleFactura(detalleFacturaDto);
        detalleFacturaRepository.save(detalleFactura);
        return detalleFacturaMapper.detalleFacturaToDto(detalleFactura);
    }
}
