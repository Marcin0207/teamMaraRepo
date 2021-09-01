package com.example.projectMara.mappers;

import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "addressName", target = "addressName")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "postalCode", target = "postalCode")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "houseNumber", target = "houseNumber")
    @Mapping(source = "localNumber", target = "localNumber")
    @Mapping(source = "isDefault", target = "isDefault")
    AddressDto mapToAddressDto(Address address);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "addressName", target = "addressName")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "postalCode", target = "postalCode")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "houseNumber", target = "houseNumber")
    @Mapping(source = "localNumber", target = "localNumber")
    @Mapping(source = "isDefault", target = "isDefault")
    Address mapToAddress(AddressDto addressDto);

}
