package com.youcode.BAMCoReport.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String parentPath;
    private String displayName;
    private String description;
    private String createdBy;
    private LocalDate creationDate;
    private LocalDate lastUpdate;


    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentPath='" + parentPath + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
