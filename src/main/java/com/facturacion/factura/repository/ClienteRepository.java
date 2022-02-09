package com.facturacion.factura.repository;

import com.facturacion.factura.model.Cliente;
import com.facturacion.factura.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

     //  @Query(value = "select * from t_invoice As a inner join t_customer As c on c.id_customer = a.id_customer where a.id_customer = ?",nativeQuery = true)
      //  List<Cliente> BuscarFacturasCliente(Integer id);

        List<Cliente> findByClienteId(Integer clienteId);
}
