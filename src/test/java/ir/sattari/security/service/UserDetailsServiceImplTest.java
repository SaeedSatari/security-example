package ir.sattari.security.service;

import ir.sattari.security.dal.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static ir.sattari.security.MotherObject.anyUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    @DisplayName("loadUserByUsername when Given Valid Username then Returns UserDetails")
    void loadUserByUsername_whenGivenValidUsername_thenReturnsUserDetails() {
        doReturn(Optional.of(anyUser())).when(userRepository).findByUsername(anyString());
        UserDetails persistedUserDetails = userDetailsService.loadUserByUsername("username");
        assertEquals(anyUser().getUsername(), persistedUserDetails.getUsername());
    }

    @Test
    @DisplayName("loadUserByUsername when Given Invalid Username then Throws Exception")
    void loadUserByUsername_whenGivenInvalidUsername_thenThrowsException() {
        doReturn(Optional.empty()).when(userRepository).findByUsername(anyString());
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("username"));

    }
}