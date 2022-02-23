package com.youcode.BAMCoReport.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@DynamicUpdate
@Table(name = "Reject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reject implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String flowType;
    private String rejectNature;
    private String entity;
    private LocalDate declarationDate;
    private String agencyCode;
    private Long userRegistrationNumber;
    private String bu;
    private String su;
    private String regionalDelegation;
    private String subDelegationType;
    private String subDelegationName;
    private String cliFileCode;
    private String rib;
    private String gravity;
    private String zoneCode;
    private boolean isWrongField;
    private String errorCode;
    private String errorLabel;
    private boolean isRequestTaken;
    private String actionDetail;
    private String file;


    @ManyToOne
    @JoinColumn(name = "takenBy", referencedColumnName = "id")
    private User takenBy;


}
