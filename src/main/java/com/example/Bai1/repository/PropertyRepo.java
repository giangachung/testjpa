package com.example.Bai1.repository;

import com.example.Bai1.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<Properties, Integer> {

}
