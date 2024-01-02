package ua.com.marketplace.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.marketplace.backend.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	boolean existsByEmail(String email);

}
