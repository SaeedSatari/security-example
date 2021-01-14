package ir.sattari.security.service;

import ir.sattari.security.controller.model.CompanyResponseModel;
import ir.sattari.security.dal.repository.CompanyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ir.sattari.security.MotherObject.anyCompany;
import static ir.sattari.security.MotherObject.anyCompanyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    @Test
    @DisplayName("fetchCompanyById when Given Existing CompanyId then Returns CompanyResponseModel")
    void fetchCompanyById_whenGivenExistingCompanyId_thenReturnsCompanyResponseModel() throws Exception {
        doReturn(Optional.of(anyCompany())).when(companyRepository).findById(anyLong());
        CompanyResponseModel persistedCompanyResponseModel = companyService.fetchCompanyById(1L);
        assertEquals(anyCompany().getName(), persistedCompanyResponseModel.getName());
    }

    @Test
    @DisplayName("fetchCompanyById when Given Not Existing CompanyId then Throws Exception")
    void fetchCompanyById_whenGivenNotExistingCompanyId_thenThrowsException() {
        doReturn(null).when(companyRepository).findById(anyLong());
        assertThrows(Exception.class, () -> companyService.fetchCompanyById(1L));
    }

    @Test
    @DisplayName("fetchCompanyByName when Given Existing Name then Returns CompanyResponseModel")
    void fetchCompanyByName_whenGivenExistingName_thenReturnsCompanyResponseModel() throws Exception {
        doReturn(Optional.of(anyCompany())).when(companyRepository).findByName(anyString());
        CompanyResponseModel persistedCompanyResponseModel = companyService.fetchCompanyByName("name");
        assertEquals(anyCompany().getName(), persistedCompanyResponseModel.getName());
    }

    @Test
    @DisplayName("fetchCompanyByName when Given Not Existing Name then Throws Exception")
    void fetchCompanyByName_whenGivenNotExistingName_thenThrowsException() {
        doReturn(null).when(companyRepository).findByName(anyString());
        assertThrows(Exception.class, () -> companyService.fetchCompanyByName("name"));
    }

    @Test
    @DisplayName("fetchAllCompanies when There Are Companies In Database then Returns List Of CompanyResponseModel")
    void fetchAllCompanies_whenThereAreCompaniesInDatabase_thenReturnsListOfCompanyResponseModel() throws Exception {
        doReturn(anyCompanyList()).when(companyRepository).findAll();
        List<CompanyResponseModel> persistedCompanyResponseModelList = companyService.fetchAllCompanies();
        assertNotNull(persistedCompanyResponseModelList);
    }

    @Test
    @DisplayName("fetchAllCompanies when There Are Not Companies In Database then Throws Exception")
    void fetchAllCompanies_whenThereAreNotCompaniesInDatabase_thenThrowsException() {
        doReturn(new ArrayList<>()).when(companyRepository).findAll();
        assertThrows(Exception.class, () -> companyService.fetchAllCompanies());
    }
}