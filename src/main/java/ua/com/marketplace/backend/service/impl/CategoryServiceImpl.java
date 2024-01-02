package ua.com.marketplace.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.marketplace.backend.model.Category;
import ua.com.marketplace.backend.repository.CategoryRepository;
import ua.com.marketplace.backend.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category readById(String id) {
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("Category with ID " + id + " not found");
        }
    }

    @Override
    public void deleteById(String id) {
        categoryRepository.delete(readById(id));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
