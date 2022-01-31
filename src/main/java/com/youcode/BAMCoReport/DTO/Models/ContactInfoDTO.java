package com.youcode.BAMCoReport.DTO.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;


@Getter
@Setter
public class ContactInfoDTO {


    @Id
    @JsonIgnore
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
    @JsonIgnore
    private String address;
    @JsonIgnore
    private String zipcode;
    @JsonIgnore
    private String city;
    @JsonIgnore
    private String state;
    @JsonIgnore
    private String country;
    @JsonIgnore
    private String website;
    @JsonIgnore
    private boolean personal;

    @JsonIgnore
    private User user_id;
}
