package com.example.Bai1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name= "productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="productpropertyname")
    private String productPropertyName;

    @Column(name= "quanlity")
    private int quanlity;

    @Column(name= "price")
    private double price;

    @Column(name= "shelprice")
    private double shelPrice;

    @Column(name= "parentId")
    private int parentId;

     @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetails")
     @JsonManagedReference
     private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductPropertyName() {
        return productPropertyName;
    }

    public void setProductPropertyName(String productPropertyName) {
        this.productPropertyName = productPropertyName;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<ProductDetailPropertyDetails> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(Set<ProductDetailPropertyDetails> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public double getShelPrice() {
        return shelPrice;
    }

    public void setShelPrice(double shelPrice) {
        this.shelPrice = shelPrice;
    }
}
