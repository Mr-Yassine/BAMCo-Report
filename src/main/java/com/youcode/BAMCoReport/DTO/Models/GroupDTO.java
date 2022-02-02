package com.youcode.BAMCoReport.DTO.Models;

import com.youcode.BAMCoReport.Entities.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

public class GroupDTO {

    @Id
    private Long id;
    private String name;
    private String parentPath;
    private String displayName;
    private String description;
    private LocalDate creationDate;
    private LocalDate lastUpdate;


    private User createdBy;
}
