package ir.sattari.security.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseModel {
    private String username;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean enabled;

    @Override
    public String toString() {
        return "UserResponseModel{" +
                "username='" + username + '\'' +
                ", accountExpired=" + accountExpired +
                ", accountLocked=" + accountLocked +
                ", enabled=" + enabled +
                '}';
    }
}
