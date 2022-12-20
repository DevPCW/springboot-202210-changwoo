package com.study.springboot202210changwoo.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private int categoryId;
    private String categoryName;
    private String outer;
    private String pants;
    private String shoes;
    private String categoryOpt1;
    private String categoryOpt2;
}
