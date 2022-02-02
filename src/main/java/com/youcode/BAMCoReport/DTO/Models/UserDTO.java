package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDate;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    @Id
    private Long id;
    private boolean enabled;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String title;
    private String jobTitle;
    private LocalDate creationDate;
    private LocalDate lastUpdate;

    private User managerUserId;
    private User createdBy;
    private UserContactInfo contactInfo;
    private Group group;
    private Profile profile;
    private Role role;


}
