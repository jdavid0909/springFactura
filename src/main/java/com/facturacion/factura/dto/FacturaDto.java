package com.facturacion.factura.dto;

import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.DetalleFactura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDto  {

    @JsonProperty("id_invoice")
    private Integer invoiceId;

    @JsonProperty
    private String invoiceCode;

    @JsonProperty
    private double status;

    @JsonProperty
    private Date date;

    @JsonIgnore
    private Cliente cliente;

    @JsonIgnore
    private List<DetalleFactura> detalleFacturas ;

    @JsonIgnore
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }
}
