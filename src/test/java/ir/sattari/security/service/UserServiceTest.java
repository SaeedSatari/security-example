package ir.sattari.security.service;

import ir.sattari.security.controller.model.UserResponseModel;
import ir.sattari.security.dal.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ir.sattari.security.MotherObject.anyUser;
import static ir.sattari.security.MotherObject.anyUserList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("fetchAllUsers when There Are Users In Database then Returns List Of UserResponseModel")
    void fetchAllUsers_whenThereAreUsersInDatabase_thenReturnsListOfUserResponseModel() throws Exception {
        doReturn(anyUserList()).when(userRepository).findAll();
        List<UserResponseModel> persistedUserResponseModelList = userService.fetchAllUsers();
        assertNotNull(persistedUserResponseModelList);
    }

    @Test
    @DisplayName("fetchAllUsers when There Are Not Users In Database then Throws Exception")
    void fetchAllUsers_whenThereAreNotUsersInDatabase_thenThrowsException() {
        doReturn(new ArrayList<>()).when(userRepository).findAll();
        assertThrows(Exception.class, () -> userService.fetchAllUsers());
    }

    @Test
    @DisplayName("fetchUserById when Given Existing UserId then Returns UserResponseModel")
    void fetchUserById_whenGivenExistingUserId_thenReturnsUserResponseModel() throws Exception {
        doReturn(Optional.of(anyUser())).when(userRepository).findById(anyLong());
        UserResponseModel persistedUserResponseModel = userService.fetchUserById(1L);
        assertEquals(anyUser().getUsername(), persistedUserResponseModel.getUsername());
    }

    @Test
    @DisplayName("fetchUserById when Given Not Existing UserId then Throws Exception")
    void fetchUserById_whenGivenNotExistingUserId_thenThrowsException() {
        doReturn(null).when(userRepository).findById(anyLong());
        assertThrows(Exception.class, () -> userService.fetchUserById(1L));
    }

    @Test
    @DisplayName("fetchUserByUserName when Given Existing Username then Returns UserResponseModel")
    void fetchUserByUserName_whenGivenExistingUsername_thenReturnsUserResponseModel() throws Exception {
        doReturn(Optional.of(anyUser())).when(userRepository).findByUsername(anyString());
        UserResponseModel persistedUserResponseModel = userService.fetchUserByUserName("username");
        assertEquals(anyUser().getUsername(), persistedUserResponseModel.getUsername());
    }

    @Test
    @DisplayName("fetchUserByUserName when Given Not Existing Username then Throws Exception")
    void fetchUserByUserName_whenGivenNotExistingUsername_thenThrowsException() {
        doReturn(null).when(userRepository).findByUsername(anyString());
        assertThrows(Exception.class, () -> userService.fetchUserByUserName("username"));
    }
}