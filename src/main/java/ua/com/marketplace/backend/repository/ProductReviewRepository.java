package ua.com.marketplace.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.marketplace.backend.model.ProductReview;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {

}
