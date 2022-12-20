package com.study.springboot202210changwoo.service;

import com.study.springboot202210changwoo.repository.OptionRepository;
import com.study.springboot202210changwoo.repository.UserRepository;
import com.study.springboot202210changwoo.web.dto.CategoryDto;
import com.study.springboot202210changwoo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository categoryRepository;

    public int addCategory(CategoryDto categoryDto) {
//        return categoryRepository.saveCategory(categoryDto) > 0 ? categoryDto.getCategoryId() : 0; = > 클린코드
        System.out.println("데이터베이스에 insert 전: " + categoryDto.getCategoryId());
        categoryRepository.saveCategory(categoryDto);
        System.out.println("데이터베이스에 insert 후: " + categoryDto.getCategoryId());
        return categoryDto.getCategoryId();
    }

    public CategoryDto getCategory(int categoryId) {
        CategoryDto categoryDto = null;
        categoryDto = categoryRepository.findCategoryByCategoryId(categoryId);
        return categoryDto;
    }

    public List<CategoryDto> getCategoryList() {
        return categoryRepository.getCategories();
    }

    public void modifyCategory(int categoryId, CategoryDto categoryDto) {
        categoryDto.setCategoryId(categoryId);
        categoryRepository.modifyCategory(categoryDto);
    }

}
