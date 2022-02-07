package com.youcode.BAMCoReport.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@DynamicUpdate
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
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate lastUpdate;



    @ManyToOne()
    @JoinColumn(name = "createdBy", referencedColumnName = "id")
    private User createdBy;


    public Group(Long id, String name, String description, LocalDate creationDate, LocalDate lastUpdate, User createdBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.createdBy = createdBy;
    }

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
