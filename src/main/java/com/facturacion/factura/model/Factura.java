package com.facturacion.factura.model;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "t_invoice")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice")
    private Integer invoiceId;

    @Column(name = "invoice_code")
    private String invoiceCode;

    @Column(name = "status")
    private double status;

    @Column(name = "added_date")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY,cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_customer")
    private Cliente cliente;


}
