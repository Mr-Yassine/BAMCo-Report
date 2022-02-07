package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;



@ApiModel("Group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupDTO {

    @Id
    private Long id;
    private String name;
    @JsonIgnore
    private String parentPath;
    @JsonIgnore
    private String displayName;
    private String description;
    private LocalDate creationDate;
    private LocalDate lastUpdate;


    private User createdBy;
}
