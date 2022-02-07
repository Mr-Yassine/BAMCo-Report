package com.youcode.BAMCoReport.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DynamicUpdate
@Table (name = "ContactInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContactInfo implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;


    private String email;
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String mobile;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String fax;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String building;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String room;
    private String address;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String zipcode;
    private String city;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String state;
    private String country;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String website;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean personal;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;


    public UserContactInfo(String email, String phone, User user_id) {
        this.email = email;
        this.phone = phone;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User_contactInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fax='" + fax + '\'' +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", website='" + website + '\'' +
                ", personal=" + personal +
                '}';
    }
}
