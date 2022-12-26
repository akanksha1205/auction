package com.auction.buyer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auction.buyer.entity.BuyerEmbedded;
import com.auction.buyer.entity.BuyerEntity;

@Repository
public interface BidingRepository extends CrudRepository<BuyerEntity, BuyerEmbedded>{
	
	@Query(value = "Select * from buyer b where b.email_id = :emailId and product_id = :productId", nativeQuery = true)
	BuyerEntity duplicateBiding(@Param("emailId")String emailId, @Param("productId")Integer productId);

}
