package com.twuc.shopping.repository;

import com.twuc.shopping.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {

}
