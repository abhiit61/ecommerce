package com.pragmatech.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pragmatech.ecommerce.dto.FullProductResponse;
import com.pragmatech.ecommerce.dto.HeaderResponse;
import com.pragmatech.ecommerce.dto.ProductProjection;
import com.pragmatech.ecommerce.dto.ProductResponse;
import com.pragmatech.ecommerce.dto.ProductSearchRequest;
import com.pragmatech.ecommerce.entity.Product;
import com.pragmatech.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public HeaderResponse<ProductResponse> findProductsByFilterParams(ProductSearchRequest filter, Pageable pageable) {
		Page<ProductProjection> products = productRepository.findProductsByFilterParams(filter.getProductrs(),
				filter.getGenders(), filter.getPrices().get(0), filter.getPrices().get(1), filter.getSortByPrice(),
				pageable);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("page-total-count", String.valueOf(products.getTotalPages()));
		responseHeaders.add("page-total-elements", String.valueOf(products.getTotalElements()));
		List<ProductResponse> productRespList = products.getContent().stream().map(list -> new ProductResponse(list))
				.collect(Collectors.toList());

		return new HeaderResponse<ProductResponse>(productRespList, responseHeaders);
	}

	public FullProductResponse getProductById(Long productId) throws Exception {
		Product p = productRepository.findById(productId).orElseThrow(() -> new Exception("Product not found."));
		return new FullProductResponse(p);
	}

}
