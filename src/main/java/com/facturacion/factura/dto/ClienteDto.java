package com.facturacion.factura.dto;

import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    @JsonProperty("clienteId")
    private int clienteId;

    @JsonProperty(required = true)
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

 //   private Factura factura;


    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


}