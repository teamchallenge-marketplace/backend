package ua.com.marketplace.backend.service;

import ua.com.marketplace.backend.model.ProductReview;

import java.util.List;

public interface ProductReviewService {
	ProductReview create(ProductReview productReview);

	ProductReview update(ProductReview productReview);

	ProductReview readById(String id);

	void deleteById(String id);

	List<ProductReview> getAll();
}
