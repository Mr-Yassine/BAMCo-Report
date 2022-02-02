package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;



public class MembershipDTO {

    @Id
    @JsonIgnore
    private Long id;
    private Long userId;
    private Long roleId;
    private Long groupId;
    @JsonIgnore
    private String assignedBy;
    @JsonIgnore
    private LocalDate assignedDate;
}
