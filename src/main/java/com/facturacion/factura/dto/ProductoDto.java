package com.facturacion.factura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@JsonSerialize
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    @JsonProperty("productoId")
    private int productoId;

    @JsonProperty(required = true)
    @NotNull
    @NotBlank
    @Size(min = 1, max = 42)
    private String nombreProducto;

    @JsonProperty(required = true)
    @NotNull
    @NotBlank
    @Size(min = 1,max = 42)
    private String stock;

    @JsonProperty(required = true)
    private boolean estado;

    @JsonProperty(required = true)
    private LocalDateTime fecha;

}
