package com.facturacion.factura.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "t_invoice_detail")
public class DetalleFactura {

    @Id
    @Column(name = "id_invoice_detail")
    private int detalleId;

    /*@EmbeddedId
    private DetalleFacturaPK id;
    */
    @Column(name = "id_invoice")
    private Integer facturaId;
    @Column(name = "id_product")
    private Integer ProductoId;
    @Column(name = "amount")
    private Double cantidad;

    @Column(name = "price")
    private Boolean precio;

    @Column(name = "total_parcial")
    private Boolean subtotal;

    @Column(name = "isv")
    private Boolean impuesto;

    @Column(name = "discount")
    private double descuento;

    @Column(name = "total")
    private double total;

    @Column(name = "status")
    private boolean status;

    @Column(name = "added_date")
    private LocalDateTime date;

}
