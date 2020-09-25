package com.twuc.shopping.repository;

import com.twuc.shopping.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity,Integer> {
}
