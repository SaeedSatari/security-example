package ir.sattari.security.controller.mapper;

import ir.sattari.security.controller.model.UserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static ir.sattari.security.MotherObject.anyUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
class UserMapperTest {

    @Test
    @DisplayName("userToUserResponseModel when Given User With Valid Username then Returns ValidUserResponseModel")
    void userToUserResponseModel_whenGivenUserWithValidUsername_thenReturnsValidUserResponseModel() {
        UserResponseModel userResponseModel = UserMapper.MAPPER.userToUserResponseModel(anyUser());
        assertTrue(userResponseModel.getUsername().contains(anyUser().getUsername()));
    }

    @Test
    @DisplayName("userToUserResponseModel when Given User With IsAccountExpired then Returns ValidUserResponseModel")
    void userToUserResponseModel_whenGivenUserWithIsAccountExpired_thenReturnsValidUserResponseModel() {
        UserResponseModel userResponseModel = UserMapper.MAPPER.userToUserResponseModel(anyUser());
        assertEquals(anyUser().isAccountExpired(), userResponseModel.isAccountExpired());
    }


    @Test
    @DisplayName("userToUserResponseModel when Given User With IsAccountLocked then Returns ValidUserResponseModel")
    void userToUserResponseModel_whenGivenUserWithIsAccountLocked_thenReturnsValidUserResponseModel() {
        UserResponseModel userResponseModel = UserMapper.MAPPER.userToUserResponseModel(anyUser());
        assertEquals(anyUser().isAccountLocked(), userResponseModel.isAccountLocked());
    }

    @Test
    @DisplayName("userToUserResponseModel when Given User With IsEnabled then Returns ValidUserResponseModel")
    void userToUserResponseModel_whenGivenUserWithIsEnabled_thenReturnsValidUserResponseModel() {
        UserResponseModel userResponseModel = UserMapper.MAPPER.userToUserResponseModel(anyUser());
        assertEquals(anyUser().isEnabled(), userResponseModel.isEnabled());
    }
}