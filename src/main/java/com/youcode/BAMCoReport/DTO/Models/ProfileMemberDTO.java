package com.youcode.BAMCoReport.DTO.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProfileMemberDTO {


    @Id
    private Long id;
    private Long profileId;
    private Long userId;
    private Long groupId;
    private Long roleId;
}
