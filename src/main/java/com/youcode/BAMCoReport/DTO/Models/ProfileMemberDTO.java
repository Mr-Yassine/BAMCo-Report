package com.youcode.BAMCoReport.DTO.Models;


import com.youcode.BAMCoReport.Entities.Group;
import com.youcode.BAMCoReport.Entities.ProfileMember;
import com.youcode.BAMCoReport.Entities.Role;
import com.youcode.BAMCoReport.Entities.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.Id;



@ApiModel("ProfileMember")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileMemberDTO {


    @Id
    private Long id;
    private ProfileMember profileId;
    private User userId;
    private Group groupId;
    private Role roleId;
}
