package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@ApiModel("Profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileDTO {

    @Id
    private Long id;
    @JsonIgnore
    private boolean isDefault;
    private String name;
    private String description;
    private LocalDate creationDate;
    private LocalDate lastUpdate;
    private User lastUpdateBy;



    private User createdBy;

}
