package com.facturacion.factura.model;


import lombok.*;

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

    @OneToMany(mappedBy = "cliente")
    List<Factura> facturas;

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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
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
