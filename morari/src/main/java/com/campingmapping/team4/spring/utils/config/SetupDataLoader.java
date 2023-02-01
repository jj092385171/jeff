package com.campingmapping.team4.spring.utils.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t401member.model.dao.repository.RoleRepository;
import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
// import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRoleRepository;
import com.campingmapping.team4.spring.t401member.model.entity.Role;
import com.campingmapping.team4.spring.t401member.model.entity.UserDetail;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import jakarta.transaction.Transactional;

@Component
// 啟動時自動執行
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    // @Autowired
    // private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 查看有無權限並創建
        if (alreadySetup)
            return;
        List<String> roles = Arrays.asList(
                "SUPERADMIN", "ADMIN", "CAMP", "SHOP", "FORUM", "MALL", "TEAM","USER");
        roles.forEach(r -> createRoleIfNotFound(r));

        // 檢查有無存在生成超級管理員
        Role adminRole = roleRepository.findByName("SUPERADMIN").get();

        Optional<UserProfiles> userOptional = userRepository.findByEmail(MyConstants.SUPER_ADMIN_NAME);
        UserProfiles userProfiles;
        UserDetail userDetail = UserDetail.builder()
        .nickname("卍~超-級=管=理-員~卐")
        .exp(999999L)
        .leavel(999999)
        .point(99999999L)
        .build();
        try{
        if (userOptional.isPresent()) {
            userProfiles = userOptional.get();
            userProfiles.setUserddetail(userDetail);
            userProfiles.setEmail(MyConstants.SUPER_ADMIN_NAME);
            userProfiles.setPassword(passwordEncoder.encode(MyConstants.SUPER_ADMIN_PASSWORD));
            userProfiles.getRoles().clear();
            userProfiles.getRoles().add(adminRole);
            userRepository.save(userProfiles);
        } else {
            // Role adminRole = roleRepository.findByName("SUPERADMIN").get();

            userProfiles = UserProfiles.builder()
                    .email(MyConstants.SUPER_ADMIN_NAME)
                    .password(passwordEncoder.encode(MyConstants.SUPER_ADMIN_PASSWORD))
                    .uid(UUID.randomUUID())
                    .userddetail(userDetail)
                    .build();
            userProfiles.getRoles().add(adminRole);
            userRepository.save(userProfiles);
        }}catch(Exception e){
            e.printStackTrace();
        }
        alreadySetup = true;
    }

    @Transactional
    public Role createRoleIfNotFound(String name) {
        return roleRepository.findByName(name)
                .orElseGet(() -> roleRepository.save(Role.builder().name(name).build()));
    }
}
