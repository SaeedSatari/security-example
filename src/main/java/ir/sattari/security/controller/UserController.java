package ir.sattari.security.controller;


import io.swagger.annotations.ApiOperation;
import ir.sattari.security.controller.model.UserResponseModel;
import ir.sattari.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "non-secure-user-controller", notes = "It's a Non Secure User API.")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "View a list of available users")
    public List<UserResponseModel> getUsers() throws Exception {
        return userService.fetchAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "View a user by given id")
    public UserResponseModel getUserById(@PathVariable Long id) throws Exception {
        return userService.fetchUserById(id);
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "View a user by given username")
    public UserResponseModel getUserByUsername(@PathVariable String username) throws Exception {
        return userService.fetchUserByUserName(username);
    }
}
