package org.example.springwiththymleft.service;

import org.example.springwiththymleft.model.Request.ProductRequest;
import org.example.springwiththymleft.model.Response.ProductResponse;
import org.example.springwiththymleft.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    ProductResponse addProduct(ProductRequest productRequest);
    ProductResponse updateProductById(Long productId,ProductRequest productRequest);
    void deleteProductById(Long productId);
    List<Product> getAllProductForThymeLeaf();
   ProductResponse getProductById(Long productId);
}
