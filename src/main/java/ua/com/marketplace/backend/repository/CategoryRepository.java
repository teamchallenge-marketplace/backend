package ua.com.marketplace.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.marketplace.backend.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
