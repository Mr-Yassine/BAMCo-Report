package com.youcode.BAMCoReport.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DynamicUpdate
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileMember implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    private Profile profileId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "id")
    private Group groupId;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Role roleId;

    @ManyToOne()
    @JoinColumn(name = "createdBy", referencedColumnName = "id")
    private User createdBy;



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


