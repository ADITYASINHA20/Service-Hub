package com.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "services")

public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String description;

    private String image;

    private Double price;

    private Double rating;

    private String category;

    public ServiceEntity() {
    }

    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // TITLE
    public String getTitle() {
        return title;
    }

    public void setTitle(
        String title
    ) {
        this.title = title;
    }

    // DESCRIPTION
    public String getDescription() {
        return description;
    }

    public void setDescription(
        String description
    ) {
        this.description =
            description;
    }

    // IMAGE
    public String getImage() {
        return image;
    }

    public void setImage(
        String image
    ) {
        this.image = image;
    }

    // PRICE
    public Double getPrice() {
        return price;
    }

    public void setPrice(
        Double price
    ) {
        this.price = price;
    }

    // RATING
    public Double getRating() {
        return rating;
    }

    public void setRating(
        Double rating
    ) {
        this.rating = rating;
    }

    // CATEGORY
    public String getCategory() {
        return category;
    }

    public void setCategory(
        String category
    ) {
        this.category = category;
    }
}