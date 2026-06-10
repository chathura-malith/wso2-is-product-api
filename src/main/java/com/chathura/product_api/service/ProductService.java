package com.chathura.product_api.service;

import com.chathura.product_api.dto.request.ProductRequestDto;
import com.chathura.product_api.dto.response.ProductResponseDto;
import com.chathura.product_api.dto.response.paginate.ProductPaginateResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    public void create(ProductRequestDto dto);

    public void update(Long id, ProductRequestDto dto);

    public void delete(Long id);

    public ProductResponseDto findById(Long id);;

    public ProductPaginateResponseDto findAll(int page, int size, String searchText);
}