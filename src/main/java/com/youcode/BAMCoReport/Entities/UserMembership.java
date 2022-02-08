package com.youcode.BAMCoReport.Entities;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DynamicUpdate
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMembership implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role roleId;
    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group groupId;
    @ManyToOne
    @JoinColumn(name = "assignedBy", referencedColumnName = "id")
    private User assignedBy;
    @CreationTimestamp
    private LocalDate assignedDate;


    @ManyToOne()
    @JoinColumn(name = "createdBy", referencedColumnName = "id")
    private User createdBy;



    @Override
    public String toString() {
        return "User_membership{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", groupId=" + groupId +
                ", assignedBy='" + assignedBy + '\'' +
                ", assignedDate=" + assignedDate +
                '}';
    }
}
