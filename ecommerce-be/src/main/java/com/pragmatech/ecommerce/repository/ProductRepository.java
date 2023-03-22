package com.pragmatech.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pragmatech.ecommerce.dto.ProductProjection;
import com.pragmatech.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT product FROM Product product " +
            "WHERE (coalesce(:productrs, null) IS NULL OR product.productr IN :productrs) " +
            "AND (coalesce(:genders, null) IS NULL OR product.productGender IN :genders) " +
            "AND (coalesce(:priceStart, null) IS NULL OR product.price BETWEEN :priceStart AND :priceEnd) " +
            "ORDER BY CASE WHEN :sortByPrice = true THEN product.price ELSE -product.price END ASC")
    Page<ProductProjection> findProductsByFilterParams(
            List<String> productrs, 
            List<String> genders, 
            Integer priceStart, 
            Integer priceEnd, 
            boolean sortByPrice,
            Pageable pageable);

	List<Product> findByIdIn(List<Long> productsIds);

	Page<ProductProjection> findByProductTitleContaining(String text, Pageable pageable);

	Page<ProductProjection> findByProductTitleContainingAndProductGender(String text, String string, Pageable pageable);
	
}
