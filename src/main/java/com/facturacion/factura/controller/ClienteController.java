package com.facturacion.factura.controller;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.service.ClienteService;
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
@RequestMapping(path = "/clientes")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("{Id}")
    public ResponseEntity<List<ClienteDto>> getProduct(@PathVariable("Id") int clienteId){

        List<ClienteDto> list = clienteService.buscarFacturas(clienteId);
        return  new ResponseEntity<>(clienteService.buscarFacturas(clienteId), HttpStatus.OK);
    }
}
