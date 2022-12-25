package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface repository extends JpaRepository<ecommerce,Integer>{

	@Query(value="SELECT * FROM ecommerce s where s.productId=?1",nativeQuery=true)
	List<ecommerce> findById(int id);
	
	
	@Query(value="SELECT * FROM ecommerce s where s.productName=?1",nativeQuery=true)
	List<ecommerce> findByName(String productName);
	
	
	@Modifying
	@Transactional
	@Query(value="Update ecommerce s set s.productId=?1 , s.productName=?2 , s.description=?3 , s.quantity=?4 , s.price=?5 , s.type=?6 where s.productId=?7", nativeQuery=true)
	void update(int productId,String productName, String description, String quantity, String price, String type, int id);
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM ecommerce where productId=?1", nativeQuery=true)
	void deleteAllByIdInBatch(int id);
}


