package com.example.Bai1.repository;

import com.example.Bai1.model.ProductDetails;
import com.example.Bai1.model.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailRepo extends JpaRepository<PropertyDetails, Integer> {

}
