package com.chathura.product_api.dto.response.paginate;

import com.chathura.product_api.dto.response.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPaginateResponseDto {
    private List<ProductResponseDto> dataList;
    private long dataCount;
}
