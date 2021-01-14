package ir.sattari.security.controller.mapper;

import ir.sattari.security.controller.model.CompanyResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static ir.sattari.security.MotherObject.anyCompany;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
class CompanyMapperTest {

    @Test
    @DisplayName("companyToCompanyResponseModel when Given Company then Returns CompanyResponseModel")
    void companyToCompanyResponseModel_whenGivenCompany_thenReturnsCompanyResponseModel() {
        CompanyResponseModel companyResponseModel = CompanyMapper.MAPPER.companyToCompanyResponseModel(anyCompany());
        assertTrue(companyResponseModel.getName().contains(anyCompany().getName()));
    }
}