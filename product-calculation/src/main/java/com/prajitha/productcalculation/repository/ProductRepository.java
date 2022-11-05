package com.prajitha.productcalculation.repository;

import com.prajitha.productcalculation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// extending jpa repository that contains the full API of CrudRepository and PagingAndSortingRepository
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
