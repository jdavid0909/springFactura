package com.facturacion.factura.dto.pegeable;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PageResponse<T> {

    Integer getPageSize();
    void setPageSize(Integer pageSize);

    Integer getNumberOfElements();
    void setNumberOfElements(Integer numberOfElements);

    int getTotalPages();
    void setTotalPages(Integer totalPages);

    Integer getPageNumber();
    void setPageNumber(Integer pageNumber);

    List<T> getPagePayload();
    void setPagePayload(List<T> pagePayload);

    default ResponseEntity<? extends PageResponse<T>> buildResponseEntity
    (Integer pageSize, Integer numberOfElements, Integer totalPages,
     Integer pageNumber, List<T> pagePayload){
        this.setPageSize(pageSize);
        this.setNumberOfElements(numberOfElements);
        this.setTotalPages(totalPages);
        this.setPageNumber(pageNumber);
        this.setPagePayload(pagePayload);
        return new ResponseEntity<>(this, HttpStatus.OK);
    }

}
