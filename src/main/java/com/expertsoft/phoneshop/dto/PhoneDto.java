package com.expertsoft.phoneshop.dto;

import com.expertsoft.phoneshop.persistence.model.Phone;

import java.math.BigDecimal;

public class PhoneDto {
    private Long id;
    private String brand;
    private String model;
    private String image;
    private String description;
    private BigDecimal price;

    public PhoneDto(Long id, String brand, String model, String image, String description, BigDecimal price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public PhoneDto(Phone phone) {
        this.id = phone.getId();
        this.brand = phone.getBrand();
        this.model = phone.getModel();
        this.image = phone.getImage();
        this.description = phone.getDescription();
        this.price = phone.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
