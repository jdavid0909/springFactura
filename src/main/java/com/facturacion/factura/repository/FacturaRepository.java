package com.facturacion.factura.repository;

import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer> {
        @Query(value = "select distinct a.added_date, a.id_invoice, c.customer_name, c.id_customer, a.status, a.invoice_code from t_customer As c inner join t_invoice As a on c.id_customer = a.id_customer where c.id_customer = ?",nativeQuery = true)
        List<Factura> BuscarFacturas(Integer id);
}
