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
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private boolean isDefault;
    private String name;
    private String description;
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate lastUpdate;
    @ManyToOne()
    @JoinColumn(name = "lastUpdateBy", referencedColumnName = "id")
    private User lastUpdateBy;


    @ManyToOne()
    @JoinColumn(name = "createdBy", referencedColumnName = "id")
    private User createdBy;




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
