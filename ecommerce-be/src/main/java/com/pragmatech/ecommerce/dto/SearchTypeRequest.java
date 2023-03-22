package com.pragmatech.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class SearchTypeRequest {
    private SearchProduct searchType;
    private String text;
    private List<String> gender;
}
