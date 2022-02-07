package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@ApiModel("Role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDTO {

    @Id
    private Long id;
    private String name;
    @JsonIgnore
    private String displayName;
    private String description;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;


    private User createdBy;
}
