package com.youcode.BAMCoReport.Entities;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@DynamicUpdate
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileMember {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profileId")
    private Profile profileId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group groupId;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role roleId;


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


