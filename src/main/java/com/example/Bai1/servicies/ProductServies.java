package com.example.Bai1.servicies;

import com.example.Bai1.RequestRespone.ProductDetailsResponse;
import com.example.Bai1.RequestRespone.ProductNotFoundException;
import com.example.Bai1.RequestRespone.PurchaseRequest;
import com.example.Bai1.RequestRespone.PurchaseResponse;
import com.example.Bai1.model.ProductDetailPropertyDetails;
import com.example.Bai1.model.ProductDetails;

import com.example.Bai1.model.Products;
import com.example.Bai1.model.Properties;
import com.example.Bai1.model.PropertyDetails;
import com.example.Bai1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServies implements IProductServies {
    //private final ProductDetailRepo productDetailRepo;

    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private ProductDetailRepo _productDetailRepo;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductDetailPropertyDetailRepo _productDetailPropertyDetailRepo;

    @Autowired
    private PropertyDetailRepo propertyDetailRepo;

    @Override
    public Integer getProductId(Integer a, Integer b) {
        return _productDetailPropertyDetailRepo.getProductId(a, b);
    }

    @Override
    public PurchaseResponse getProductIds(Integer a, Integer b, Integer quantity) {
        Integer productDetailId = getProductId(a, b);
        Optional<ProductDetails> optionalProductDetails = _productDetailRepo.findById(productDetailId);
        if (optionalProductDetails.isPresent()) {
            ProductDetails productDetails = optionalProductDetails.get();

            if (productDetails.getQuanlity() < quantity) {
                return new PurchaseResponse(HttpStatus.BAD_REQUEST, "Khong du so luong san pham");
            }
            if (productDetails.getQuanlity() == 0) {
                return new PurchaseResponse(HttpStatus.BAD_REQUEST, "Het hang");
            }
            if (productDetails.getQuanlity() >= quantity) {
                productDetails.setQuanlity(productDetails.getQuanlity() - quantity);
                _productDetailRepo.saveAndFlush(productDetails);
                return new PurchaseResponse(HttpStatus.OK, "Mua hang thanh cong");
            } else {
                return new PurchaseResponse(HttpStatus.NOT_FOUND, "San pham khong ton tai");
            }
        }
        return null;
    }

    @Override
    public PurchaseResponse updateProductQuantity(Integer a, Integer b, int newQuantity) throws ProductNotFoundException {
        Integer productDetailId = getProductId(a, b);
        Optional<ProductDetails> optionalProductDetails = _productDetailRepo.findById(productDetailId);
        if (optionalProductDetails.isPresent()) {
            ProductDetails productDetails = optionalProductDetails.get();
            Set<ProductDetailPropertyDetails> productDetailPropertyDetailsList = productDetails.getProductDetailPropertyDetails();
            if (newQuantity < 0) {
                return new PurchaseResponse(HttpStatus.BAD_REQUEST, "Khong hop le");
            } else {
                productDetails.setQuanlity(productDetails.getQuanlity() + newQuantity);
                _productDetailRepo.saveAndFlush(productDetails);
                return new PurchaseResponse(HttpStatus.OK, "Cap nhap thanh cong");
            }

        } else {
            return new PurchaseResponse(HttpStatus.NOT_FOUND, "San pham khong ton tại");
        }

    }

//    @Override
//    public List<ProductDetails> getProductDetails(Integer x) {
//        return _productDetailRepo.getProductDetails(x);
//    }
//

    @Override
    public List<ProductDetails> getProductDetails(Integer x) {
        return _productDetailRepo.getProductDetails(x);
    }
}