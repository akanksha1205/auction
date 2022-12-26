package com.auction.seller.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auction.seller.entity.BuyerEntity;
import com.auction.seller.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Integer>{

}
