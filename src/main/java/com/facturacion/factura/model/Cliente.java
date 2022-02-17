package com.facturacion.factura.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer clienteId;

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


    @OneToMany(mappedBy = "cliente",cascade =  CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    List<Factura> facturas = new ArrayList<>();


}
