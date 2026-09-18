package com.expertsoft.phoneshop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "phoneshop")
public class PhoneShopProperties {
    private int plpMaxPages = 5;

    public int getPlpMaxPages() {
        return plpMaxPages;
    }

    public void setPlpMaxPages(int plpMaxPages) {
        this.plpMaxPages = plpMaxPages;
    }
}
