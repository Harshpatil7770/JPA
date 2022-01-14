package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BrandDao;
import com.example.demo.dao.CategoryDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	@Autowired
	BrandDao brandDao;

	@Autowired
	CategoryDao categoryDao;

	public Brand addNewBrand(Brand brand) {
		return brandDao.save(brand);
	}

	public List<Brand> addNewListOfBrands(List<Brand> brands) {
		return brandDao.saveAll(brands);
	}

	public Category addNewCategory(Category category) {
		return categoryDao.save(category);
	}

	public List<Category> addNewListOfCategory(List<Category> categories) {
		return categoryDao.saveAll(categories);
	}

	public Product addNewProduct(Product product) {
		return productDao.save(product);
	}

	public List<Product> addNewListOfProduct(List<Product> products) {
		return productDao.saveAll(products);
	}

	public List<Product> fetchAll() {
		return productDao.findAll();
	}

	public List<Brand> fetchAllBrands() {
		return brandDao.findAll();
	}

	public List<Category> fetchAllCategory() {
		return categoryDao.findAll();
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productDao.findById(product.getId()).orElse(product);
		existingProduct.setId(product.getId());
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		return productDao.save(product);
	}

	public Brand updateBrand(Brand brand) {
		Brand existingBrand = brandDao.findById(brand.getId()).orElse(brand);
		existingBrand.setId(brand.getId());
		existingBrand.setName(brand.getName());
		return brandDao.save(brand);
	}

	public Category updateCategory(Category category) {
		Category existingCategory = categoryDao.findById(category.getId()).orElse(category);
		existingCategory.setId(category.getId());
		existingCategory.setCategoryName(category.getCategoryName());
		return categoryDao.save(category);
	}

	public Optional<Product> getById(int id) {
		return productDao.findById(id);
	}

	
	public List<Product> findProductByCategoryName(String categoryName) {
		return productDao.findByCategoryName(categoryName);
	}

	public List<Product> findProductByBrandName(String name) {
		return productDao.findByName(name);
	}

	public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
		return productDao.findByPriceBetween(minPrice, maxPrice);
	}

	public void deleteById(int id) {
		productDao.deleteById(id);
	}
}
