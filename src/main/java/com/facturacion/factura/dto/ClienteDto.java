package com.facturacion.factura.dto;

import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto implements Serializable {

    @JsonProperty("id_customer")
    @JsonIgnore
    private Integer clienteId;

    @JsonProperty
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 32)
    private String nombre;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 32)
    private String direccion;

    @JsonProperty(required = true)
    @Positive
    @NotNull
    private Integer telefono;

    @JsonProperty(required = true)
    private boolean estado;

    @JsonProperty(required = true)
    private LocalDateTime fecha;

    @JsonProperty
    @Builder.Default
    private List<Factura> facturas = new ArrayList<>() ;




}
