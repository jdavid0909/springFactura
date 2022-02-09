package com.facturacion.factura.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.time.LocalDateTime;
@JsonSerialize
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DetalleFacturaDto {

    private int detalleId;
    private Integer facturaId;
    private Integer ProductoId;
    private Double cantidad;
    private Boolean precio;
    private Boolean subtotal;
    private Boolean impuesto;
    private double descuento;
    private double total;
    private boolean status;
    private LocalDateTime date;
}
