package ir.sattari.security.controller.mapper;

import ir.sattari.security.controller.model.CompanyResponseModel;
import ir.sattari.security.dal.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);

    @Mapping(target = "name", source = "name")
    CompanyResponseModel companyToCompanyResponseModel(Company source);

}
