package org.example.springwiththymleft.mapper;

import org.example.springwiththymleft.model.Request.ProductRequest;
import org.example.springwiththymleft.model.Response.ProductResponse;
import org.example.springwiththymleft.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductRequest productRequest);

    @Mapping(source = "category.categoryName", target = "categoryName" )
    ProductResponse toProductResponse(Product product);

    List<ProductResponse> toProductResponse(List<Product> products);

    @Mapping(target = "category", ignore = true) // still set manually
    void updateProductFromRequest(ProductRequest request, @MappingTarget Product product);
}
