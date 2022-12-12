package com.sviridofficial.blogapi.service;

import com.sviridofficial.blogapi.exception.UnauthorizedException;
import com.sviridofficial.blogapi.model.Category;
import com.sviridofficial.blogapi.payload.ApiResponse;
import com.sviridofficial.blogapi.payload.PagedResponse;
import com.sviridofficial.blogapi.security.UserPrincipal;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

	PagedResponse<Category> getAllCategories(int page, int size);

	ResponseEntity<Category> getCategory(Long id);

	ResponseEntity<Category> addCategory(Category category, UserPrincipal currentUser);

	ResponseEntity<Category> updateCategory(Long id, Category newCategory, UserPrincipal currentUser)
			throws UnauthorizedException;

	ResponseEntity<ApiResponse> deleteCategory(Long id, UserPrincipal currentUser) throws UnauthorizedException;

}
