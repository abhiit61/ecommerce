package com.pragmatech.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import com.pragmatech.ecommerce.entity.Product;

@Getter
@Setter
@NoArgsConstructor
public class FullProductResponse extends ProductResponse {
    public FullProductResponse(Product p) {
		this.country = p.getCountry();
		this.description = p.getDescription();
		this.file = null;
		this.fragranceBaseNotes = p.getFragranceBaseNotes();
		this.fragranceMiddleNotes = p.getFragranceMiddleNotes();
		this.fragranceTopNotes = p.getFragranceTopNotes();
		this.productGender = p.getProductGender();
		this.type = p.getType();
		this.year = p.getYear();
		setFilename(p.getFilename());
		setId(p.getId());
		setPrice(p.getPrice());
		setProductr(p.getProductr());
		setProductRating(5D);
		setProductTitle(p.getProductTitle());
		setReviewsCount(5);
		setType(p.getType());
		setVolume(p.getVolume());
	}
	private Integer year;
    private String country;
    private String productGender;
    private String fragranceTopNotes;
    private String fragranceMiddleNotes;
    private String fragranceBaseNotes;
    private String description;
    private String type;
    private MultipartFile file;
}
