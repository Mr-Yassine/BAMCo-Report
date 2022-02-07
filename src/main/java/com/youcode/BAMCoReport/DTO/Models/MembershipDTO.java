package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.Group;
import com.youcode.BAMCoReport.Entities.Role;
import com.youcode.BAMCoReport.Entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@ApiModel("Membership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MembershipDTO {

    @Id
    private Long id;
    private User userId;
    private Role roleId;
    private Group groupId;
    private User assignedBy;
    private LocalDate assignedDate;
}
