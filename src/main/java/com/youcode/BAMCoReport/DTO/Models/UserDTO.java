package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.*;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDate;



@ApiModel("User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {



    private Long id;
    private boolean enabled;
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    @JsonIgnore
    private String lastName;
    @JsonIgnore
    private String title;
    private String jobTitle;
    private LocalDate creationDate;
    private LocalDate lastUpdate;
    private User lastUpdateBy;

    private UserContactInfo contactInfo;
    private User createdBy;
    private User managerUserId;






}
