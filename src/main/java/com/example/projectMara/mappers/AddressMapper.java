package com.example.projectMara.mappers;

import com.example.projectMara.adapter.dto.AddressDto;
import com.example.projectMara.domain.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {


    AddressDto mapToAddressDto(Address address);

    Address mapToAddress(AddressDto addressDto);

}
