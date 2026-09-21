package com.expertsoft.phoneshop.dto;

import com.expertsoft.phoneshop.enums.Role;
import com.expertsoft.phoneshop.persistence.model.User;

public class UserDto {
    private Long id;
    private String login;
    private Role role;
    private String name;
    private String bio;
    private String avatarUrl;
    private String location;
    private String company;

    public UserDto(Long id, String login, Role role, String name, String bio, String avatarUrl, String location, String company) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.name = name;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.location = location;
        this.company = company;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.role = user.getRole();
        this.name = user.getName();
        this.bio = user.getBio();
        this.avatarUrl = user.getAvatarUrl();
        this.location = user.getLocation();
        this.company = user.getCompany();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
