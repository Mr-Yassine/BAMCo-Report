package com.youcode.BAMCoReport.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContactInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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



    @JsonBackReference
    @OneToOne(targetEntity = User.class)
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
