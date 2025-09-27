package org.example.springwiththymleft.controller;

import lombok.RequiredArgsConstructor;
import org.example.springwiththymleft.model.Request.ProductRequest;
import org.example.springwiththymleft.model.Response.ApiResponse;
import org.example.springwiththymleft.model.Response.ProductResponse;
import org.example.springwiththymleft.model.entity.Product;
import org.example.springwiththymleft.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProduct(){
        return ResponseEntity.ok().body(new ApiResponse<>(true,"Fetch Product Successfully" ,productService.getAllProduct(), LocalDateTime.now()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> addProduct(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(new ApiResponse<>(true,"Add Product Successfully", productService.addProduct(productRequest),LocalDateTime.now()));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ProductResponse>> updateProductByProductId(@RequestParam Long productId, @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(new ApiResponse<>(true,"Update Product Successfully", productService.updateProductById(productId, productRequest),LocalDateTime.now()));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<String>> deleteProductById(@RequestParam Long productId){
        return ResponseEntity.ok(new ApiResponse<>(true,"Delete Product Successfully", "",LocalDateTime.now()));
    }

    @GetMapping("/listAllProduct")
    public ModelAndView routeToListAllProduct(){
        List<Product> products = productService.getAllProductForThymeLeaf();
        ModelAndView modelAndView = new ModelAndView("ListAllProduct");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/addProduct")
    public ModelAndView routeToForm(){
        ProductRequest productRequest = new ProductRequest();
        ModelAndView modelAndView = new ModelAndView("FormAddProduct");
        modelAndView.addObject("productRequest", productRequest);
        return modelAndView;
    }

    @PostMapping("/addProduct")
    public ModelAndView addProductInThymeleaf(@ModelAttribute ProductRequest productRequest){
        productService.addProduct(productRequest);
        return new ModelAndView("redirect:/api/v1/products/listAllProduct");
    }

    @GetMapping("/deleteProductById/{productId}")
    public ModelAndView deleteProductId(@PathVariable Long productId){
        productService.deleteProductById(productId);
        return new ModelAndView("redirect:/api/v1/products/listAllProduct");
    }

}
