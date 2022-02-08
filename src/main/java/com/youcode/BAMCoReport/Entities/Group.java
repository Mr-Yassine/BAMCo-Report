package com.youcode.BAMCoReport.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@DynamicUpdate
@Table(name = "Groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
