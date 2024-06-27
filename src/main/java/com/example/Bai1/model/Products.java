package com.example.Bai1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="productname")
    private String productName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    @JsonManagedReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    @JsonManagedReference
    private Set<Properties> properties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<ProductDetailPropertyDetails> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(Set<ProductDetailPropertyDetails> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }
}
