package com.facturacion.factura.repository;

import com.facturacion.factura.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // @Query(value = "select * from t_customer As c inner join t_invoice As a on a.id_customer = c.id_customer where c.id_customer = :id",nativeQuery = true)
    Page<Cliente> findByClienteId(Integer clienteId, Pageable pageable);
   // Page<Customer> findByCustomerIdContaining(String customerId, Pageable pageable);
     //List<Cliente> findByClienteId(Integer clienteId);
  // Page<Cliente> findByClienteIdContaining(Integer clienteId, Pageable pageable);
  // @Query(value = "select * from t_customer As c inner join t_invoice As a on a.id_customer = c.id_customer where c.id_customer = :id",nativeQuery = true)
   Page<Cliente> findByClienteIdContaining(Integer id, Pageable pageable);
}
