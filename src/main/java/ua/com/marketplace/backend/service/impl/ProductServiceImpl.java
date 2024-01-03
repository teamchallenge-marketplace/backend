package ua.com.marketplace.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.marketplace.backend.model.Product;
import ua.com.marketplace.backend.repository.ProductRepository;
import ua.com.marketplace.backend.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product readById(String id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("Product with ID " + id + " not found");
        }
    }

    @Override
    public void deleteById(String id) {
        productRepository.delete(readById(id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}