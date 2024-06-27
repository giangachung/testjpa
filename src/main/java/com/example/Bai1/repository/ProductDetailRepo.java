package com.example.Bai1.repository;

import com.example.Bai1.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetails, Integer> {
    @Query(value = """
        SELECT pd.id, pd.productpropertyname, pd.price, pd.quanlity, pd.shelprice, pd.parent_id
        FROM productdetails pd
        JOIN productdetailpropertydetails pdpd ON pd.id = pdpd.productdetailid
        JOIN products p ON pdpd.productid = p.id
        JOIN properties ppt ON ppt.productid = p.id
        WHERE ppt.productid = :x
        GROUP BY pd.id, pd.productpropertyname, pd.price, pd.quanlity, pd.shelprice, pd.parent_id
        HAVING COUNT(ppt.productid) = 2
    """, nativeQuery = true)

    public List<ProductDetails> getProductDetails(Integer x);
}
