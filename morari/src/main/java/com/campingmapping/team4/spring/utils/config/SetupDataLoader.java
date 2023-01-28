package com.campingmapping.team4.spring.utils.config;

import java.util.Arrays;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t401member.model.dao.repository.RoleRepository;
import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.Role;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

import jakarta.transaction.Transactional;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        createRoleIfNotFound("SUPERADMIN");
        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("CAMP");
        createRoleIfNotFound("SHOP");
        createRoleIfNotFound("FORUM");
        createRoleIfNotFound("MALL");
        createRoleIfNotFound("TEAM");

        Role adminRole = roleRepository.findByName("ADMIN").get();
        UserProfiles userProfiles = UserProfiles.builder()
                .email("admin@admin.com")
                .password(passwordEncoder.encode("0000"))
                .roles(Arrays.asList(adminRole))
                .build();
        userRepository.save(userProfiles);

        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByName(name).get();
        if (role == null) {
            role = Role.builder().name(name).build();
            roleRepository.save(role);
        }
        return role;
    }

}
