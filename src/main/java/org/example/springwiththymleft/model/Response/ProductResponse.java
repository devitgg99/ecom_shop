package org.example.springwiththymleft.model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long productId;
    private String name;
    private String description;
    private Double originalPrice;
    private Double priceForSell;
    private String image;
    private Long quantity;
    private Long categoryId;
    private Long brandId;
}
