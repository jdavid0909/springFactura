package com.facturacion.factura.repository;

import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

        @Query(value = "select * from factura when id_cliente = ? ",nativeQuery = true)
        List<Factura> getFacturasById(int clienteId);
}
