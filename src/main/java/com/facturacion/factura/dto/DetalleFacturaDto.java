package com.facturacion.factura.dto;

import com.facturacion.factura.model.Factura;
import com.facturacion.factura.model.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@JsonSerialize
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDto {

    @JsonProperty("detalleId")
    private int detalleId;
    @JsonProperty
    private Double cantidad;
    @JsonProperty
    private double precio;
    @JsonProperty
    private Double subtotal;
    @JsonProperty
    private Double impuesto;
    @JsonProperty
    private double descuento;
    @JsonProperty
    private double total;
    @JsonProperty
    private boolean status;
    @JsonProperty
    private LocalDateTime date;

    @JsonProperty
    private Producto producto;

    // @JsonIgnore
    @JsonIgnore
    private Factura factura;


}
