package com.youcode.BAMCoReport.Entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.youcode.BAMCoReport.DTO.Models.ContactInfoDTO;
import com.youcode.BAMCoReport.DTO.Models.UserDTO;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@DynamicUpdate
@Table (name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean enabled;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String firstName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String lastName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String title;
    private String jobTitle;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @CreationTimestamp
    private LocalDate creationDate;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @UpdateTimestamp
    private LocalDate lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lastupdateby")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User lastUpdateBy;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="managerUserId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User managerUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="createdby")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User createdBy;



    @OneToOne(targetEntity = UserContactInfo.class, cascade = CascadeType.ALL, mappedBy = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserContactInfo contactInfo;







}
