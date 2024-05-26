package com.servicedomain.productcatalogmanagement.framework.adapters.in;

import com.servicedomain.productcatalogmanagement.application.ports.in.ProductCatalogManagementUseCase;
import com.servicedomain.productcatalogmanagement.domain.dtos.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product Catalog Management", description = "API for managing product catalog")
public class ProductCatalogManagementController {

    private final ProductCatalogManagementUseCase productService;

    @GetMapping
    @Operation(summary = "Get list of all products")
    public ResponseEntity<List<ProductDTO>> getProductsList() {
        return ResponseEntity.ok(productService.getProductsList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing product")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id,
                                                    @RequestBody ProductDTO product) {
        product.setId(id);
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product by ID")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
