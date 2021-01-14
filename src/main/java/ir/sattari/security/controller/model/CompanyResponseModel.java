package ir.sattari.security.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponseModel {
    private String name;

    @Override
    public String toString() {
        return "CompanyResponseModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
