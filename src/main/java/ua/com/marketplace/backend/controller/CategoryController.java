package ua.com.marketplace.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.marketplace.backend.dto.ApiResponse;
import ua.com.marketplace.backend.service.CategoryService;
import ua.com.marketplace.backend.util.ApiResponseProvider;

import java.util.Map;

@CrossOrigin(origins = {
        "http://localhost:5173/",
        "https://main--keen-swan-fa2324.netlify.app/"
})
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

    @GetMapping("/descendants/{parentId}")
    public ResponseEntity<ApiResponse> getChildCategories(@PathVariable String parentId) {
        Map<String, Object> childCategories = Map.of(
                "parent",
                categoryService.readById(parentId),
                "descendants",
                categoryService.getAllChildCategories(parentId)
        );

        return responseProvider.getApiResponse(HttpStatus.OK, childCategories);
    }

}
