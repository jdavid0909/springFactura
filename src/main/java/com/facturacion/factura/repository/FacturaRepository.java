package com.facturacion.factura.repository;

import com.facturacion.factura.dto.FacturaDto;
import com.facturacion.factura.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FacturaRepository extends JpaRepository<Factura,Integer> {
        @Query(value = "select * from t_customer As c inner join t_invoice As a on c.id_customer = a.id_customer where c.id_customer = ?",nativeQuery = true)
        List<Factura> BuscarFacturas(Integer id);
}
