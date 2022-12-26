package com.auction.seller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auction.seller.entity.BuyerEmbedded;
import com.auction.seller.entity.BuyerEntity;

@Repository
public interface BuyerRepository extends CrudRepository<BuyerEntity, BuyerEmbedded>{
	
	@Query(value = "Select * from buyer b where b.product_id = :productId", nativeQuery = true)
	List<BuyerEntity> findBidingDetail(@Param("productId")Integer productId);
	
//	@Modifying
//	@Query(value = "Delete from buyer b where b.product_id = :productId", nativeQuery = true)
//	void deleteProduct(@Param("productId")Integer productId);

}
