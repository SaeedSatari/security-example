package ir.sattari.security.service;

import ir.sattari.security.controller.mapper.UserMapper;
import ir.sattari.security.controller.model.UserResponseModel;
import ir.sattari.security.dal.entity.User;
import ir.sattari.security.dal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserResponseModel> fetchAllUsers() throws Exception {
        List<User> users = userRepository.findAll();
        List<UserResponseModel> models = users.stream().map(UserMapper.MAPPER::userToUserResponseModel).collect(Collectors.toList());
        if (users.isEmpty()) {
            throw new Exception("Users not found.");
        } else {
            return models;
        }
    }

    @Transactional(readOnly = true)
    public UserResponseModel fetchUserById(Long id) throws Exception {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            return UserMapper.MAPPER.userToUserResponseModel(foundUser.get());
        } else {
            throw new Exception("User with given id not found");
        }
    }

    @Transactional(readOnly = true)
    public UserResponseModel fetchUserByUserName(String username) throws Exception {
        Optional<User> foundUser = userRepository.findByUsername(username);
        if (foundUser.isPresent()) {
            return UserMapper.MAPPER.userToUserResponseModel(foundUser.get());
        } else {
            throw new Exception("User with given username not found");
        }
    }
}
