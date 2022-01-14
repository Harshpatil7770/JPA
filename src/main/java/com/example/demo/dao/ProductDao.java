package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query(value="select * from products p inner join brands b on p.brand_brand_id=b.brand_id inner join categories c on p.category_category_id=c.category_id where brand_name=?",nativeQuery=true)
	List<Product> findProductByBrandName(String name);

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	List<Product> findByName(String name);

	@Query(value="select * from products p inner join brands b on p.brand_brand_id=b.brand_id inner join categories c on p.category_category_id=c.category_id where category_name=?",nativeQuery = true)
	List<Product> findByCategoryName(String categoryName);

}
