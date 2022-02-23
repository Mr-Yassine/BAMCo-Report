package com.youcode.BAMCoReport.Configuration;

import com.youcode.BAMCoReport.Entities.Group;
import com.youcode.BAMCoReport.Entities.Role;
import com.youcode.BAMCoReport.Entities.User;
import com.youcode.BAMCoReport.Entities.UserMembership;
import com.youcode.BAMCoReport.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static java.util.Calendar.FEBRUARY;


@Configuration
public class AdminConfig {

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AdminConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    CommandLineRunner commandLineRunner (IUserRepository adminRepository,
                                         IRoleRepository roleRepository,
                                         IMembershipRepository membershipRepository,
                                         IGroupRepository groupRepository) {
        return args -> {
            User ADMIN = new User(
                    1L,
                    true,
                    "yassine__bilal",
                    passwordEncoder.encode("1234"),
                    "Yassine",
                    "BILAL",
                    "SUPER ADMIN",
                    "Super Admin",
                    LocalDate.of(2022, FEBRUARY, 2),
                    LocalDate.of(2022, FEBRUARY, 6),
                    null,
                    null,
                    null,
                    null,
                    null
            );

            adminRepository.save(
                    ADMIN
            );





            Group group = new Group(
                    1L,
                    "adm grp",
                    "api/group",
                    "Admins Group",
                    "This group is for admins",
                    LocalDate.of(2022, FEBRUARY, 2),
                    LocalDate.of(2022, FEBRUARY, 6),
                    ADMIN
            );

            groupRepository.save(
                    group
            );





            Role role = new Role(
                    1L,
                    "admin",
                    "ADMIN",
                    "This is the super admin",
                    LocalDate.of(2022, FEBRUARY, 2),
                    LocalDate.of(2022, FEBRUARY, 6),
                    ADMIN
            );

            roleRepository.save(
                    role
            );





            UserMembership membership = new UserMembership(
                    1L,
                    ADMIN,
                    role,
                    group,
                    ADMIN,
                    LocalDate.of(2022, FEBRUARY, 2),
                    ADMIN
            );

            membershipRepository.save(
                    membership
            );
        };
    }
}
