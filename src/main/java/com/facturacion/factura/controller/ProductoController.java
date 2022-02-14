package com.facturacion.factura.controller;

import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.dto.ProductoDto;
import com.facturacion.factura.dto.pegeable.PageResponse;
import com.facturacion.factura.dto.pegeable.PageResponseDto;
import com.facturacion.factura.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "/productos")
@RequiredArgsConstructor
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<? extends PageResponse<ProductoDto>> getCustomerById(
            @RequestParam(required = false) String concidencia,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "product_name, desc") String[] sort) {


        Page<ProductoDto> productoDtos = productoService
                .buscarConcidencias(concidencia,page,size,sort);

        PageResponseDto<ProductoDto> pageResponseDto = new PageResponseDto<>();
        return pageResponseDto.buildResponseEntity(productoDtos.getSize(), productoDtos.getNumberOfElements(),
                productoDtos.getTotalPages(), productoDtos.getNumber(), productoDtos.getContent());
    }
}
