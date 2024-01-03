package ua.com.marketplace.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.marketplace.backend.model.ProductReview;
import ua.com.marketplace.backend.repository.ProductReviewRepository;
import ua.com.marketplace.backend.service.ProductReviewService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductReviewServiceImpl implements ProductReviewService {

    private final ProductReviewRepository productReviewRepository;


    @Override
    public ProductReview create(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    @Override
    public ProductReview update(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    @Override
    public ProductReview readById(String id) {
        Optional<ProductReview> optional = productReviewRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("Product Review with ID " + id + " not found");
        }
    }

    @Override
    public void deleteById(String id) {
        productReviewRepository.delete(readById(id));
    }

    @Override
    public List<ProductReview> getAll() {
        return productReviewRepository.findAll();
    }
}
