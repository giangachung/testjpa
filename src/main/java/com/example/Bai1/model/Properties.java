package com.example.Bai1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "propertyname")
    private String propertyName;

    @Column(name = "propertySort")
    private int propertySort;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "properties")
    @JsonManagedReference
    private Set<PropertyDetails> propertyDetails;

    @Column(name="productid", insertable = false, updatable = false)
    private int propertyId;

    @ManyToOne
    @JoinColumn(name="productid")
    @JsonBackReference
    private Products products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertySort() {
        return propertySort;
    }

    public void setPropertySort(int propertySort) {
        this.propertySort = propertySort;
    }

    public Set<PropertyDetails> getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(Set<PropertyDetails> propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
