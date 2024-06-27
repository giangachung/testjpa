package com.example.Bai1.repository;

import com.example.Bai1.model.ProductDetailPropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailPropertyDetailRepo extends JpaRepository<ProductDetailPropertyDetails, Integer> {
@Query(value = """

select pdpd.productdetailid
from kiemtra.productdetailpropertydetails pdpd
where pdpd.propertydetailid in(:a, :b)
group by pdpd.productdetailid
having count( pdpd.productdetailid) = 2
""",nativeQuery = true)
    public Integer getProductId( Integer a, Integer b);

}
