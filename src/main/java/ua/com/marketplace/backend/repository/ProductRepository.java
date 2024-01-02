package ua.com.marketplace.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.marketplace.backend.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
