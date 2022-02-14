package com.facturacion.factura.service.implementation;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.ProductoDto;
import com.facturacion.factura.model.mapper.ProductoMapper;
import com.facturacion.factura.repository.ProductoRepository;
import com.facturacion.factura.service.ProductoService;
import com.facturacion.factura.utils.SortingPagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductoImplementation implements ProductoService {

    @Autowired
    private final SortingPagingUtils sortingPagingUtils;

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    @Override
    public Page<ProductoDto> buscarConcidencias(String nombre, int page, int size, String[] sort) {

        List<Sort.Order> orders = sortingPagingUtils.getSortOrders(sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(orders));
        List<ProductoDto> productoDtos;

        if(nombre == null){
            productoDtos = productoMapper.productoToDto(productoRepository.findAll(pageable).toList());

        } else {
            productoDtos = productoMapper.productoToDto(productoRepository.concidenciaProductos(nombre,pageable).toList());
        }
        return new PageImpl<>(productoDtos);
    }
}
