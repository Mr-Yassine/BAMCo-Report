package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.BAMCoReport.Entities.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileDTO {

    @Id
    private Long id;
    private boolean isDefault;
    private String name;
    private String description;
    private LocalDate creationDate;
    private String lastUpdateBy;
    private LocalDate lastUpdate;


    private User createdBy;

}
