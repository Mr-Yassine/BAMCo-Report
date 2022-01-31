package com.youcode.BAMCoReport.DTO.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private boolean isDefault;
    private String name;
    private String description;
    private LocalDate creationDate;
    @JsonIgnore
    private String createdBy;
    @JsonIgnore
    private String lastUpdateBy;
    @JsonIgnore
    private LocalDate lastUpdate;
}
