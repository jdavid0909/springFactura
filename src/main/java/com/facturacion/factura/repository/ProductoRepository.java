package com.facturacion.factura.repository;

import com.facturacion.factura.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query(value ="SELECT * FROM t_products p inner join t_invoice_detail i on i.id_product = p.id_product  WHERE p.product_name like %:nombre%" ,nativeQuery = true)
    Page<Producto> concidenciaProductos(String nombre, Pageable pageable);

}
