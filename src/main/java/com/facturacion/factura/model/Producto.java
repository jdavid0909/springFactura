package com.facturacion.factura.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_products")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int productoId;

    @Column(name = "product_name")
    private String nombreProducto;

    @Column(name = "stock")
    private String stock;

    @Column(name = "status")
    private boolean estado;

    @Column(name = "added_date")
    private LocalDateTime fecha;

}
