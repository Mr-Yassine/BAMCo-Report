package com.youcode.BAMCoReport.DTO.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;

@ApiModel("ContactInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactInfoDTO {

    @Id
    private Long id;
    private String email;
    private String phone;
    @JsonIgnore
    private String mobile;
    @JsonIgnore
    private String fax;
    @JsonIgnore
    private String building;
    @JsonIgnore
    private String room;
    private String address;
    @JsonIgnore
    private String zipcode;
    private String city;
    @JsonIgnore
    private String state;
    private String country;
    @JsonIgnore
    private String website;
    @JsonIgnore
    private boolean personal;


    @JsonIgnore
    private UserDTO user_id;

}
