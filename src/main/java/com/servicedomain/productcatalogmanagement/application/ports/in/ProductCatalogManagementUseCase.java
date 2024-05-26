package com.servicedomain.productcatalogmanagement.application.ports.in;

import com.servicedomain.productcatalogmanagement.domain.dtos.ProductDTO;

import java.util.List;

public interface ProductCatalogManagementUseCase {

    List<ProductDTO> getProductsList();
    ProductDTO findById(String id);
    ProductDTO save(ProductDTO product);
    void deleteById(String id);
}
