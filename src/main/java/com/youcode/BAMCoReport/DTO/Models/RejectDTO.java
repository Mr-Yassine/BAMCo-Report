package com.youcode.BAMCoReport.DTO.Models;


import com.youcode.BAMCoReport.Entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDate;


@ApiModel("Reject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RejectDTO {

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


    private User takenBy;

}
