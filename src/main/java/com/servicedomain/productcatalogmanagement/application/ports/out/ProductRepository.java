package com.servicedomain.productcatalogmanagement.application.ports.out;

import com.servicedomain.productcatalogmanagement.domain.dtos.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<ProductDTO> getProductsList();
    Optional<ProductDTO> findById(String id);
    ProductDTO save(ProductDTO product);
    void deleteById(String id);
}
