package com.facturacion.factura.model.mapper;

import com.facturacion.factura.dto.DetalleFacturaDto;
import com.facturacion.factura.dto.ProductoDto;
import com.facturacion.factura.model.DetalleFactura;
import com.facturacion.factura.model.Producto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto dtoToProdcuto(ProductoDto productoDto);

    ProductoDto productoToDto(Producto producto);

    List<Producto> dtoToProducto(List<ProductoDto> productoDtos);

    List<ProductoDto> productoToDto(List<Producto> productos);
}
