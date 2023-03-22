package com.pragmatech.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragmatech.ecommerce.dto.FullProductResponse;
import com.pragmatech.ecommerce.dto.HeaderResponse;
import com.pragmatech.ecommerce.dto.ProductResponse;
import com.pragmatech.ecommerce.dto.ProductSearchRequest;
import com.pragmatech.ecommerce.dto.SearchTypeRequest;
import com.pragmatech.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/search")
	public ResponseEntity<List<ProductResponse>> findProductsByFilterParams(@RequestBody ProductSearchRequest filter,
			@PageableDefault(size = 8) Pageable pageable) {
		HeaderResponse<ProductResponse> response = productService.findProductsByFilterParams(filter, pageable);
		return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
	}
	
	@GetMapping("/{productId}")
    public ResponseEntity<FullProductResponse> getProductById(@PathVariable Long productId) throws Exception {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

	@PostMapping("/search/text")
    public ResponseEntity<List<ProductResponse>> findByInputText(@RequestBody SearchTypeRequest searchType,
                                                                 @PageableDefault(size = 8) Pageable pageable) {
		HeaderResponse<ProductResponse> response = productService.findByInputText(searchType.getSearchType(), 
        		searchType.getText(), searchType.getGender(), pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }
	
}
