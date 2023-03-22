package com.pragmatech.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "year")
    private Integer year;
    
    @Column(name = "productr")
    private String productr;
    
    @Column(name = "country")
    private String country;

    @Column(name = "product_gender")
    private String productGender;

    @Column(name = "fragrance_top_notes")
    private String fragranceTopNotes;

    @Column(name = "fragrance_middle_notes")
    private String fragranceMiddleNotes;
    
    @Column(name = "fragrance_base_notes")
    private String fragranceBaseNotes;

    @Column(name = "description")
    private String description;
    
    @Column(name = "filename")
    private String filename;
    
    @Column(name = "price")
    private Integer price;
    
    @Column(name = "volume")
    private String volume;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "product_rating")
    private Double productRating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
