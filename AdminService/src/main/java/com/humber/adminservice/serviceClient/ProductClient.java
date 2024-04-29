package com.humber.adminservice.serviceClient;

import com.humber.adminservice.entity.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("product-service")
public interface ProductClient {
    @PostMapping("/create")
    public ResponseEntity<ProductDetail> addNewProductDetail(@RequestBody ProductDetail productDetail);

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDetail>> getAllProductDetails();

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<ProductDetail>> getProductById(@PathVariable Long productId);

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId);
}
