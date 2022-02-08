package com.youcode.BAMCoReport.Entities;

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
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String name;
    private String displayName;
    private String description;
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate lastUpdateDate;


    @ManyToOne()
    @JoinColumn(name = "createdBy", referencedColumnName = "id")
    private User createdBy;


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
