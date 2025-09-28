package org.example.springwiththymleft.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.springwiththymleft.mapper.ProductMapper;
import org.example.springwiththymleft.model.Request.ProductRequest;
import org.example.springwiththymleft.model.Response.ProductResponse;
import org.example.springwiththymleft.model.entity.Brand;
import org.example.springwiththymleft.model.entity.Category;
import org.example.springwiththymleft.model.entity.Product;
import org.example.springwiththymleft.repository.BrandRepository;
import org.example.springwiththymleft.repository.CategoryRepository;
import org.example.springwiththymleft.repository.ProductRepository;
import org.example.springwiththymleft.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProduct() {
        return productMapper.toProductResponse(productRepository.findAll());
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);

        // fetch category from DB
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Brand brand = brandRepository.findById(productRequest.getBrandId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        product.setBrand(brand);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse updateProductById(Long productId,ProductRequest productRequest) {
        Product existing = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productMapper.updateProductFromRequest(productRequest, existing);
        // fetch category from DB
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setCategory(category);
        return productMapper.toProductResponse(productRepository.save(existing));
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAllProductForThymeLeaf() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        return productMapper.toProductResponse(productRepository.getById(productId));
    }

}
