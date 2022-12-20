package com.study.springboot202210changwoo.repository;

import com.study.springboot202210changwoo.web.dto.CategoryDto;
import com.study.springboot202210changwoo.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
    public CategoryDto findCategoryByCategoryId(int categoryId);
    public List<CategoryDto> getCategories();

    public int modifyCategory(CategoryDto categoryDto);
}
