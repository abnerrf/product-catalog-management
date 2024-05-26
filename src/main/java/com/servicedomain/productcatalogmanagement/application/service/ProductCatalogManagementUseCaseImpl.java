package com.servicedomain.productcatalogmanagement.application.service;

import com.servicedomain.productcatalogmanagement.application.ports.in.ProductCatalogManagementUseCase;
import com.servicedomain.productcatalogmanagement.application.ports.out.ProductRepository;
import com.servicedomain.productcatalogmanagement.domain.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCatalogManagementUseCaseImpl implements ProductCatalogManagementUseCase {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductsList() {
        return productRepository.getProductsList();
    }

    @Override
    public ProductDTO findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
