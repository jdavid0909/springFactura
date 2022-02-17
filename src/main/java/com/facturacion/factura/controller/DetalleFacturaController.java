package com.facturacion.factura.controller;

import com.facturacion.factura.dto.DetalleFacturaDto;
import com.facturacion.factura.service.DetalleFacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/detallesFactura")
@RequiredArgsConstructor
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @PostMapping
    public ResponseEntity<DetalleFacturaDto> guardar(@RequestBody DetalleFacturaDto detalleFacturaDto){
        System.out.println("detalleFacturaDto");
        return new ResponseEntity<>(detalleFacturaService.guardarDetalle(detalleFacturaDto), HttpStatus.CREATED);
    }
}
