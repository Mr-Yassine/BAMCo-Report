package com.youcode.BAMCoReport.Entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private boolean isDefault;
    private String name;
    private String description;
    @CreationTimestamp
    private LocalDate creationDate;
    private String lastUpdateBy;
    @UpdateTimestamp
    private LocalDate lastUpdate;


    @ManyToOne()
    @JoinColumn(name = "createdBy", referencedColumnName = "createdBy")
    private User createdBy;


    public Profile(Long id, String name, String description, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }



    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", isDefault=" + isDefault +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
