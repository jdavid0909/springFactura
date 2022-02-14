package com.facturacion.factura.service.implementation;

import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Factura;
import com.facturacion.factura.model.mapper.FacturaMapper;
import com.facturacion.factura.repository.FacturaRepository;
import com.facturacion.factura.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaImplementation implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private FacturaMapper facturaMapper;

    @Override
    public List<FacturaDto> buscarFacturas(Integer id) {
    List<FacturaDto> facturaDtos;
      //  List<Factura> facturas =facturaRepository.BuscarFacturas(id);
        facturaDtos = facturaMapper
                .toFacturaDto(facturaRepository.BuscarFacturas(id));
            return facturaDtos ;

    }
}
