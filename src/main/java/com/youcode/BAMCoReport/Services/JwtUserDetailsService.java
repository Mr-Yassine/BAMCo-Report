package com.youcode.BAMCoReport.Services;

import java.util.*;

import com.youcode.BAMCoReport.DTO.Models.UserDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.UserMembership;
import com.youcode.BAMCoReport.Repositories.IMembershipRepository;
import com.youcode.BAMCoReport.Repositories.IRoleRepository;
import com.youcode.BAMCoReport.Repositories.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    IMapClassWithDto<User, UserDTO> userMapping;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IMembershipRepository membershipRepository;
    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    RoleService roleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.youcode.BAMCoReport.Entities.User> user = userRepository.findUserByUsername(username);

        if (user.isEmpty()) {
            log.error("User not found");
            throw new UsernameNotFoundException("user not found");
        }

        log.info("user found");


        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        UserMembership membership = membershipRepository.findByUserId(user.get());
        System.out.println(membership);
        log.info("{} / {} / {}",user.get().getId(),user.get().getUsername(),user.get().getPassword());

        String role = roleService.findById(membership.getRoleId().getId()).getName();

        authorities.add(new SimpleGrantedAuthority(role));
        return new User(user.get().getUsername(),user.get().getPassword(),authorities);
    }

}
