package com.example.projectMara.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {


    private Integer id;
    private String addressName;
    private String country;
    private String postalCode;
    private String city;
    private String street;
    private String houseNumber;
    private String localNumber;
    private Boolean isDefault;

    public boolean checkNull() {
        return (this.addressName == null
                || this.country == null
                || this.postalCode == null
                || this.city == null
                || this.street == null
                || this.houseNumber == null
                || this.isDefault == null);
    }

    public boolean addressName() {
        return this.addressName.length() > 50;
    }
}
