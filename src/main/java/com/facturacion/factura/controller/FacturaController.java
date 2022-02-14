package com.facturacion.factura.controller;


import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.dto.pegeable.PageResponse;
import com.facturacion.factura.dto.pegeable.PageResponseDto;
import com.facturacion.factura.model.Factura;
import com.facturacion.factura.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/facturas")
@RequiredArgsConstructor
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("{Id}")
    public ResponseEntity<List<FacturaDto>> getProduct(@PathVariable("Id") int facturaId){

        List<FacturaDto> list = facturaService.buscarFacturas(facturaId);
         return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<? extends PageResponse<FacturaDto>> getCustomerById(
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "invoice_code, desc") String[] sort) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        Date converFechaInicio = formato.parse(fechaInicio);
        Date converFechaFin = formato.parse(fechaFin);

        Page<FacturaDto> facturaDtosPage = facturaService
                .buscarFacturasFechas(converFechaInicio,converFechaFin,page,size,sort);

        PageResponseDto<FacturaDto> pageResponseDto = new PageResponseDto<>();
        return pageResponseDto.buildResponseEntity(facturaDtosPage.getSize(), facturaDtosPage.getNumberOfElements(),
                facturaDtosPage.getTotalPages(), facturaDtosPage.getNumber(), facturaDtosPage.getContent());
    }
}
