package ua.com.marketplace.backend.service;

import org.springframework.data.domain.Page;
import ua.com.marketplace.backend.model.Category;

import java.util.List;

public interface CategoryService {
	Category create(Category product);

	Category update(Category product);

	Category readById(String id);

	void deleteById(String id);

	List<Category> getAll();

	List<Category> getAllChildCategories(String parentId);
}
