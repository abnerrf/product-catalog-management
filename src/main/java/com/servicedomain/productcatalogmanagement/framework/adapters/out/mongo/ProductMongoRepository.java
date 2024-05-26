package com.servicedomain.productcatalogmanagement.framework.adapters.out.mongo;

import com.servicedomain.productcatalogmanagement.application.ports.out.ProductRepository;
import com.servicedomain.productcatalogmanagement.domain.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductMongoRepository implements ProductRepository {

    private final SpringDataMongoProdutoRepository repository;

    @Autowired
    public ProductMongoRepository(SpringDataMongoProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> getProductsList() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductDTO> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        return repository.save(product);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

interface SpringDataMongoProdutoRepository extends MongoRepository<ProductDTO, String> {
}