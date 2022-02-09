package com.facturacion.factura.model;


import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "t_customer")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int clienteId;

    @Column(name = "customer_name")
    private String nombre;

    @Column(name = "address")
    private String direccion;

    @Column(name = "phone")
    private Long telefono;

    @Column(name = "status")
    private boolean estado;

    @Column(name = "added_date")
    private LocalDateTime fecha;

    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "cliente", fetch = FetchType.LAZY)
    List<Factura> facturas;




}
