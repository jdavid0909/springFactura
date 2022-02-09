package com.facturacion.factura.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleFacturaPK {

    @Column(name = "id_invoice")
    private Integer facturaId;
    @Column(name = "id_product")
    private Integer ProductoId;
}
