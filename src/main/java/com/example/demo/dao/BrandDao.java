package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Brand;
import com.example.demo.model.Product;
@Repository
public interface BrandDao extends JpaRepository<Brand, Integer>{

	/*
	 * @Query(
	 * value="select * from products p inner join brands b on p.brand_brand_id=b.brand_id where b.brand_name=?"
	 * ,nativeQuery = true) List<Product> findProductByName(String name);
	 */

}
