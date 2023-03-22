package com.pragmatech.ecommerce.dto;

public interface ProductProjection {
	Long getId();
    String getProductTitle();
    String getProductr();
    Integer getPrice();
    String getFilename();
    
    void setProductr(String productr);
    void setProductGender(String productGender);
    void setPrice(Integer price);
}
