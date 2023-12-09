package ua.com.marketplace.backend.service;

import ua.com.marketplace.backend.model.Product;

import java.util.List;

public interface ProductService {
	Product create(Product product);

	Product update(Product product);

	Product readById(String id);

	void deleteById(String id);

	List<Product> getAll();

}
