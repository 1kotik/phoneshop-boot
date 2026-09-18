package com.expertsoft.phoneshop.dto;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class SearchParametersData {
    private String name;
    @Min(value = 0, message = "Price must be positive")
    private BigDecimal fromPrice;
    @Min(value = 0, message = "Price must be positive")
    private BigDecimal toPrice;

    public SearchParametersData(String name, BigDecimal fromPrice, BigDecimal toPrice) {
        this.name = name;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(BigDecimal fromPrice) {
        this.fromPrice = fromPrice;
    }

    public BigDecimal getToPrice() {
        return toPrice;
    }

    public void setToPrice(BigDecimal toPrice) {
        this.toPrice = toPrice;
    }
}
