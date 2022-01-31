package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.UserContactInfo;
import lombok.*;


import javax.persistence.Id;
import java.time.LocalDate;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {


    @Id
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private boolean enabled;
    private String username;
    private String password;
    private String firstName;
    @JsonIgnore
    private String lastName;
    @JsonIgnore
    private String title;
    private String jobTitle;
    @JsonIgnore
    private Long managerUserId;
    @JsonIgnore
    private String createdBy;
    @JsonIgnore
    private LocalDate creationDate;
    @JsonIgnore
    private LocalDate lastUpdate;

    private UserContactInfo contactInfo;

}
