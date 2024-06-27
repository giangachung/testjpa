package com.example.Bai1.servicies;

import com.example.Bai1.RequestRespone.ProductNotFoundException;
import com.example.Bai1.RequestRespone.PurchaseRequest;
import com.example.Bai1.RequestRespone.PurchaseResponse;
import com.example.Bai1.model.ProductDetails;
import com.example.Bai1.repository.ProductDetailRepo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductServies {
    //PurchaseResponse purchaseProducts(PurchaseRequest request);
    PurchaseResponse updateProductQuantity(Integer a, Integer b, int newQuantity);
    Integer getProductId(Integer a, Integer b);
    PurchaseResponse getProductIds(Integer a, Integer b, Integer quality);
    List<ProductDetails> getProductDetails(Integer x);
}
