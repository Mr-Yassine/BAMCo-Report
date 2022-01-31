package com.youcode.BAMCoReport.Entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileMember {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long profileId;
    private Long userId;
    private Long groupId;
    private Long roleId;


    @Override
    public String toString() {
        return "ProfileMember{" +
                "id=" + id +
                ", profileId=" + profileId +
                ", userId=" + userId +
                ", groupId=" + groupId +
                ", roleId=" + roleId +
                '}';
    }
}


