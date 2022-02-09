package com.facturacion.factura.dto;

import com.facturacion.factura.model.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@JsonSerialize
public class FacturaDto {

    @JsonProperty("invoiceId")
    private int invoiceId;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 32)
    private String invoiceCode;

    @JsonProperty(required = true)
    private double status;

    @JsonProperty(required = true)
    private LocalDateTime date;

    @JsonProperty(required = true)
    private Cliente cliente;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
