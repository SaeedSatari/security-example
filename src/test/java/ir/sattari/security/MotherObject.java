package ir.sattari.security;


import ir.sattari.security.controller.model.UserResponseModel;
import ir.sattari.security.dal.entity.Company;
import ir.sattari.security.dal.entity.User;

import java.util.Collections;
import java.util.List;

public class MotherObject {

    public static User anyUser() {
        User user = new User();
        user.setAccountExpired(false);
        user.setAccountLocked(false);
        user.setCredentialsExpired(false);
        user.setEnabled(true);
        user.setId(1L);
        user.setPassword("password");
        user.setUsername("username");
        return user;
    }

    public static List<User> anyUserList() {
        return Collections.singletonList(anyUser());
    }

    public static UserResponseModel anyUserResponseModel() {
        UserResponseModel model = new UserResponseModel();
        model.setUsername("username");
        model.setAccountExpired(false);
        model.setAccountLocked(false);
        model.setEnabled(true);
        return model;
    }

    public static List<UserResponseModel> anyUserResponseModelList() {
        return Collections.singletonList(anyUserResponseModel());
    }

    public static Company anyCompany() {
        Company company = new Company();
        company.setId(1L);
        company.setName("company");
        return company;
    }

    public static List<Company> anyCompanyList() {
        return Collections.singletonList(anyCompany());
    }
}
