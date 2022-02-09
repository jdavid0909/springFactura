package com.facturacion.factura.controller;


import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Factura;
import com.facturacion.factura.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/facturas")
@RequiredArgsConstructor
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/{Id}")
    public ResponseEntity<List<FacturaDto>> getProduct(@PathVariable("Id") int facturaId){

        List<FacturaDto> list = facturaService.buscarFacturas(facturaId);
         return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
