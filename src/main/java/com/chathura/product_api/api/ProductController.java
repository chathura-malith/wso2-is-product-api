package com.chathura.product_api.api;

import com.chathura.product_api.dto.request.ProductRequestDto;
import com.chathura.product_api.service.ProductService;
import com.chathura.product_api.util.StandardResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<StandardResponseDto> createProduct(@Valid @RequestBody ProductRequestDto dto) {
        productService.create(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "Product created successfully", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseDto> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(
                new StandardResponseDto(200, "Product fetched successfully", productService.findById(id)),
                HttpStatus.OK
        );
    }


    @GetMapping("/find-all")
    public ResponseEntity<StandardResponseDto> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "") String searchText
    ) {
        return new ResponseEntity<>(
                new StandardResponseDto(200, "Products fetched successfully", productService.findAll(page, size, searchText)),
                HttpStatus.OK
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseDto> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDto dto
    ) {
        productService.update(id, dto);
        return new ResponseEntity<>(
                new StandardResponseDto(200, "Product updated successfully", null),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseDto> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(
                new StandardResponseDto(204, "Product deleted successfully", null),
                HttpStatus.NO_CONTENT
        );
    }
}