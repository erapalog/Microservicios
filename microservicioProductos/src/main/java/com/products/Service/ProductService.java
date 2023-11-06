package com.products.Service;

import java.util.List;

import com.products.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getSingleProduct(int productId);
}
