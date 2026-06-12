package com.chathura.product_api.service.impl;

import com.chathura.product_api.dto.request.ProductRequestDto;
import com.chathura.product_api.dto.response.ProductResponseDto;
import com.chathura.product_api.dto.response.paginate.ProductPaginateResponseDto;
import com.chathura.product_api.entity.Product;
import com.chathura.product_api.exception.ResourceNotFoundException;
import com.chathura.product_api.mapper.ProductMapper;
import com.chathura.product_api.repo.ProductRepo;
import com.chathura.product_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public void create(ProductRequestDto dto) {
        Product product = productMapper.toEntity(dto);
        productRepo.save(product);
    }

    @Override
    public void update(Long id, ProductRequestDto dto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
        productMapper.updateProductFromDto(dto, product);
        productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        if (!productRepo.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }
        productRepo.deleteById(id);
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        return productMapper.toDto(product);
    }

    @Override
    public ProductPaginateResponseDto findAll(int page, int size, String searchText) {
        Page<Product> productPage = productRepo.searchAllProduct(searchText, PageRequest.of(page, size));

        List<ProductResponseDto> dtoList = productPage.getContent().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());

        return new ProductPaginateResponseDto(dtoList, productPage.getTotalElements());
    }
}
