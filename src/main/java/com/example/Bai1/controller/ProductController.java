package com.example.Bai1.controller;

import com.example.Bai1.RequestRespone.PurchaseResponse;
import com.example.Bai1.servicies.ProductServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductServies productServies;

    @PostMapping("purchase")
    public ResponseEntity<String> getProductIds(@RequestParam Integer a, @RequestParam Integer b, @RequestParam Integer quanlity) {
        PurchaseResponse response = productServies.getProductIds(a, b, quanlity);
        return ResponseEntity.status(response.getStatusCode()).body(response.getMessage());
    }

    @PutMapping("/quantity")
    public ResponseEntity<String> updateProductQuantity(@RequestParam Integer a, @RequestParam Integer b,  @RequestParam("quantity") int newQuantity) {
            PurchaseResponse response = productServies.updateProductQuantity(a,b, newQuantity);
            return ResponseEntity.status(response.getStatusCode()).body(response.getMessage());
    }
    @PutMapping("/test")
    public ResponseEntity<Integer> getIdProduct(Integer a, Integer b) {
        return ResponseEntity.ok(productServies.getProductId(a,b));
    }

    @PutMapping("/productlist")
    public ResponseEntity<?> getProductDetails(Integer x) {
        return ResponseEntity.ok(productServies.getProductDetails(x));
    }

}
