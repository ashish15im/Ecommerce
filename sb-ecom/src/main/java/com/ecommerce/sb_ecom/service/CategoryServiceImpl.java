package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.Exception.ResourceNotFoundException;
import com.ecommerce.sb_ecom.com.ecommerce.sb_ecom.CategoryRepo;
import com.ecommerce.sb_ecom.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class CategoryServiceImpl implements CategoryService {

//    private List<Category> categories=new ArrayList<>();
    @Autowired
    private CategoryRepo categoryRepo;
//    private Long nextId=1L;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(category);
        categoryRepo.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category> categories=categoryRepo.findAll();
        Category category=categories.stream().
                                filter(c->c.getCategoryId().
                                equals(categoryId)).findFirst().
                                orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
        if(category==null)return "Category not found";
        categoryRepo.delete(category);
        return "category with categoryId: " + categoryId +" deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category,Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepo.findById(categoryId);

        Category savedCategory = savedCategoryOptional
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND), "Rsc not found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepo.save(category);
        return savedCategory;
    }
    }

