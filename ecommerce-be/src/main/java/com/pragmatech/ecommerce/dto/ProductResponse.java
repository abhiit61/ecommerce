package com.pragmatech.ecommerce.dto;

import com.pragmatech.ecommerce.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {
    public ProductResponse(ProductProjection pp) {
		this.id = pp.getId();
		this.productTitle = pp.getProductTitle();
		this.productr = pp.getProductr();
		this.price = pp.getPrice();
		this.productRating = 5D;
		this.filename = pp.getFilename();
		this.reviewsCount = 5;
		this.volume = "5";
	}
	public ProductResponse(Product pp) {
		this.id = pp.getId();
		this.productTitle = pp.getProductTitle();
		this.productr = pp.getProductr();
		this.price = pp.getPrice();
		this.productRating = 5D;
		this.filename = pp.getFilename();
		this.reviewsCount = 5;
		this.volume = "5";
	}
	private Long id;
    private String productTitle;
    private String productr;
    private Integer price;
    private Double productRating;
    private String filename;
    private Integer reviewsCount;
    private String volume;
}
