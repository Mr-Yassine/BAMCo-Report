package com.youcode.BAMCoReport.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table (name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private boolean enabled;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String title;
    private String jobTitle;
    private Long managerUserId;
    private String createdBy;
    private LocalDate creationDate;
    private LocalDate lastUpdate;


    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "user_id")
    private UserContactInfo contactInfo;


    public User(Long id, String username, String password, String firstName, String jobTitle, UserContactInfo contactInfo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.contactInfo = contactInfo;
    }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", managerUserId=" + managerUserId +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
