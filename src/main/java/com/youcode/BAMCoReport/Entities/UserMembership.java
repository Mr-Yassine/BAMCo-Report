package com.youcode.BAMCoReport.Entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMembership {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long roleId;
    private Long groupId;
    private String assignedBy;
    private LocalDate assignedDate;



    public UserMembership(Long id, Long userId, Long roleId, Long groupId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.groupId = groupId;
    }

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
