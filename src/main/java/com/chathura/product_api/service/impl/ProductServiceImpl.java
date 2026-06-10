package com.chathura.product_api.service.impl;

import com.chathura.product_api.dto.request.ProductRequestDto;
import com.chathura.product_api.dto.response.ProductResponseDto;
import com.chathura.product_api.dto.response.paginate.ProductPaginateResponseDto;
import com.chathura.product_api.repo.ProductRepo;
import com.chathura.product_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public void create(ProductRequestDto dto) {

    }

    @Override
    public void update(Long id, ProductRequestDto dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductResponseDto findById(Long id) {
        return null;
    }

    @Override
    public ProductPaginateResponseDto findAll(int page, int size, String searchText) {
        return null;
    }
}
