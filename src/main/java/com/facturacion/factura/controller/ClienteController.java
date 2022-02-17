package com.facturacion.factura.controller;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.dto.ProductoDto;
import com.facturacion.factura.dto.openapi.PageResponseClienteDto;
import com.facturacion.factura.dto.pegeable.PageResponse;
import com.facturacion.factura.dto.pegeable.PageResponseDto;
import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

   /* @GetMapping("{Id}/facturas")
    public ResponseEntity<List<ClienteDto>> getProduct(@PathVariable("Id") int clienteId){

        List<ClienteDto> list = clienteService.buscarFacturas(clienteId);
        return  new ResponseEntity<>(clienteService.buscarFacturas(clienteId), HttpStatus.OK);
    }*/

   @GetMapping("lista")
   public ResponseEntity<List<ClienteDto>> getAllEmployees(
           @RequestParam(defaultValue = "0") Integer pageNo,
           @RequestParam(defaultValue = "2") Integer pageSize,
           @RequestParam(defaultValue = "clienteId") String sortBy)
   {
       List<ClienteDto> list = clienteService.getAllEmployees(pageNo, pageSize, sortBy);

       return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
   }
    /**
     * Get Paginated sorted CLIENTE with given criteria.
     *
     * @param clienteId Integer clienteId
     * @param page          Page number
     * @param size          page size
     * @param sort          Sort params
     * @return ResponseEntity PageResponse clienteDto
     */
    @Operation(summary = "Get a list of paginated/sorted cliente", operationId = "getClienteById")
    @ApiResponse(responseCode = "200", description = "List of cliente retrieved successfully."
            , content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE
            , schema = @Schema(implementation = PageResponseClienteDto.class))})
//    @GetMapping(params = {"clienteId", "page", "size", "sort"})
    @GetMapping
    public ResponseEntity<? extends PageResponse<ClienteDto>> getCustomerById(
            @RequestParam(required = false) int clienteId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "nombre, desc") String[] sort) {


        Page<ClienteDto> customerDtoPage = clienteService
                .findPaginatedSortedCustomer(clienteId, page, size, sort);

        PageResponseDto<ClienteDto> pageResponseDto = new PageResponseDto<>();
        return pageResponseDto.buildResponseEntity(customerDtoPage.getSize(), customerDtoPage.getNumberOfElements(),
                customerDtoPage.getTotalPages(), customerDtoPage.getNumber(), customerDtoPage.getContent());
    }

    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto clienteDto){

        return new ResponseEntity<>(clienteService.save(clienteDto),HttpStatus.CREATED);
    }


}
