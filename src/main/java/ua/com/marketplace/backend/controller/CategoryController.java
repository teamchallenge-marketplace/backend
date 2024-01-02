package ua.com.marketplace.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.marketplace.backend.dto.ApiResponse;
import ua.com.marketplace.backend.service.CategoryService;
import ua.com.marketplace.backend.util.ApiResponseProvider;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final ApiResponseProvider responseProvider;


    @GetMapping
    public ResponseEntity<ApiResponse> getCategories() {

        return responseProvider.getApiResponse(HttpStatus.OK, categoryService.getAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> getCategory(@PathVariable String categoryId) {

        return responseProvider.getApiResponse(HttpStatus.OK, categoryService.readById(categoryId));
    }

}
