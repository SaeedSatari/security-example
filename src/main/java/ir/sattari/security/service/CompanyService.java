package ir.sattari.security.service;

import ir.sattari.security.controller.mapper.CompanyMapper;
import ir.sattari.security.controller.model.CompanyResponseModel;
import ir.sattari.security.dal.entity.Company;
import ir.sattari.security.dal.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Saeed Satari
 */
@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('COMPANY_READ')")
    public CompanyResponseModel fetchCompanyById(Long id) throws Exception {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            return CompanyMapper.MAPPER.companyToCompanyResponseModel(company.get());
        } else {
            throw new Exception("Company with given id not found");
        }
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('COMPANY_READ')")
    public CompanyResponseModel fetchCompanyByName(String name) throws Exception {
        Optional<Company> company = companyRepository.findByName(name);
        if (company.isPresent()) {
            return CompanyMapper.MAPPER.companyToCompanyResponseModel(company.get());
        } else {
            throw new Exception("Company with given name not found");
        }
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('COMPANY_READ')")
    public List<CompanyResponseModel> fetchAllCompanies() throws Exception {
        List<Company> companies = companyRepository.findAll();
        List<CompanyResponseModel> models = companies.stream().map(CompanyMapper.MAPPER::companyToCompanyResponseModel).collect(Collectors.toList());
        if (companies.isEmpty()) {
            throw new Exception("Companies not found.");
        } else {
            return models;
        }
    }
}
