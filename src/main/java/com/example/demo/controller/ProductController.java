package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/ecart")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/add/brand")
	public Brand addNewBrand(@RequestBody Brand brand) {
		return productService.addNewBrand(brand);
	}

	@PostMapping("/add/new/brands")
	public List<Brand> addNewListOfBrands(@RequestBody List<Brand> brands) {
		return productService.addNewListOfBrands(brands);
	}

	@PostMapping("/add/new/category")
	public Category addNewCategory(@RequestBody Category category) {
		return productService.addNewCategory(category);
	}

	@PostMapping("/add/new/list/category")
	public List<Category> addNewListOfCategory(@RequestBody List<Category> categories) {
		return productService.addNewListOfCategory(categories);
	}

	@PostMapping("/product")
	public Product addNewProduct(@RequestBody Product product) {
		return productService.addNewProduct(product);
	}

	@PostMapping("/add/list/new/products")
	public List<Product> addNewListOfProduct(@RequestBody List<Product> products) {
		return productService.addNewListOfProduct(products);
	}

	@GetMapping("/fetchAll/products")
	public List<Product> fetchAll() {
		return productService.fetchAll();
	}

	@GetMapping("/fetch/all/brands")
	public List<Brand> fetchAllBrands() {
		return productService.fetchAllBrands();
	}

	@GetMapping("/fetch/allcategory")
	public List<Category> fetchAllCategory() {
		return productService.fetchAllCategory();
	}

	@PutMapping("/update/products")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@PutMapping("/update/existing/brand")
	public Brand updateBrand(@RequestBody Brand brand) {
		return productService.updateBrand(brand);
	}

	@PutMapping("/update/existingcategory")
	public Category updateCategory(@RequestBody Category category) {
		return productService.updateCategory(category);
	}

	@GetMapping("/filter/{id}")
	public Optional<Product> getById(@PathVariable int id) {
		return productService.getById(id);
	}

	@GetMapping("/filter/product/byname/{categoryName}")
	public List<Product> findProductByCategoryName(@PathVariable String categoryName) {
		return productService.findProductByCategoryName(categoryName);
	}

	@GetMapping("/filter/product/bybrand/{name}")
	public List<Product> findProductByBrandName(@PathVariable String name) {
		return productService.findProductByBrandName(name);
	}

	@GetMapping("/filter/byprice/{minPrice}/{maxPrice}")
	public List<Product> filterByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice) {
		return productService.filterByPriceRange(minPrice, maxPrice);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		productService.deleteById(id);
	}

}
