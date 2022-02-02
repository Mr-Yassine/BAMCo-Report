package com.youcode.BAMCoReport.DTO.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
public class ContactInfoDTO {

    @Id
    private Long id;


    private String email;
    private String phone;
    private String mobile;
    private String fax;
    private String building;
    private String room;
    private String address;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private String website;
    private boolean personal;


    private User user_id;

}
