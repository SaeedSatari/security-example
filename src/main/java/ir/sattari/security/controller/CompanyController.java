package ir.sattari.security.controller;

import io.swagger.annotations.ApiOperation;
import ir.sattari.security.controller.model.CompanyResponseModel;
import ir.sattari.security.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation(value = "secure-company-controller", notes = "It's a Secure Company API.")
@RestController
@RequestMapping(value = "/secured/companies", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "View a list of available companies")
    public List<CompanyResponseModel> getCompanies() throws Exception {
        return companyService.fetchAllCompanies();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "View a company by given id")
    public CompanyResponseModel getCompanyById(@PathVariable Long id) throws Exception {
        return companyService.fetchCompanyById(id);
    }
}