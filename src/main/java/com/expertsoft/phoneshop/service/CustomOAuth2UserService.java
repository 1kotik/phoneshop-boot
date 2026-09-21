package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.enums.Role;
import com.expertsoft.phoneshop.persistence.model.User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Resource
    private UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) {
        OAuth2User oAuth2User = super.loadUser(request);
        String login = oAuth2User.getAttribute("login");
        createUserIfNotExists(oAuth2User, login);
        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                oAuth2User.getAttributes(),
                "login");
    }

    private void createUserIfNotExists(OAuth2User oAuth2User, String login) {
        Optional<User> user = userService.findByLogin(login);
        if (user.isEmpty()) {
            User userToSave = new User(
                    login,
                    Role.USER,
                    oAuth2User.getAttribute("name"),
                    oAuth2User.getAttribute("bio"),
                    oAuth2User.getAttribute("avatar_url"),
                    oAuth2User.getAttribute("location"),
                    oAuth2User.getAttribute("company"));
            userService.createUser(userToSave);
        }
    }
}