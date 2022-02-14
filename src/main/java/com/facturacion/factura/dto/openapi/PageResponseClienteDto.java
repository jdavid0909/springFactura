package com.facturacion.factura.dto.openapi;

import com.facturacion.factura.dto.ClienteDto;
import com.facturacion.factura.dto.pegeable.PageResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "PageResponseClienteDto")
public class PageResponseClienteDto extends PageResponseDto<ClienteDto> {
}
