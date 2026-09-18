package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.dto.UserDto;
import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.persistence.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public Page<UserDto> getUsersPage(Pageable pageRequest) {
        Page<User> users = userRepository.findAll(pageRequest);
        return users.map(UserDto::new);
    }

    public Optional<User> findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }

    public void createUser(final User user) {
        userRepository.save(user);
    }

}