package com.auction.buyer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.auction.buyer.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {

}
