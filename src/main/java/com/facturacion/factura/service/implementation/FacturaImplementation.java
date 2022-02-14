package com.facturacion.factura.service.implementation;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Factura;
import com.facturacion.factura.model.mapper.FacturaMapper;
import com.facturacion.factura.repository.FacturaRepository;
import com.facturacion.factura.service.FacturaService;
import com.facturacion.factura.utils.SortingPagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaImplementation implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private final SortingPagingUtils sortingPagingUtils;

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

    @Override
    public Page<FacturaDto> buscarFacturasFechas(Date fechaInicio, Date fechaFin, int page, int size, String[] sort) {

        List<Sort.Order> orders = sortingPagingUtils.getSortOrders(sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(orders));
        List<FacturaDto> facturaDtos;

        if(fechaFin == null && fechaInicio == null){
            facturaDtos = facturaMapper.toFacturaDto(facturaRepository.findAll(pageable).toList());

        } else {
            facturaDtos = facturaMapper.toFacturaDto(facturaRepository.BuscarFacturasPorfechas(fechaInicio, fechaFin, pageable).toList());
        }
        return new PageImpl<>(facturaDtos);
    }
}
