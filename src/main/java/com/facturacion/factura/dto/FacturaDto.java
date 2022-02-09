package com.facturacion.factura.dto;

import com.facturacion.factura.model.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class FacturaDto implements Serializable {

    @JsonProperty("invoiceId")
    private int invoiceId;

    @JsonProperty
    private String invoiceCode;

    @JsonProperty
    private double status;

    @JsonProperty
    private LocalDateTime date;

   // private Cliente cliente;



}
