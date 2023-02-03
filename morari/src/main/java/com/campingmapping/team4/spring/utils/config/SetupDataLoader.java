package com.campingmapping.team4.spring.utils.config;

import java.util.Arrays;
import java.util.Date;
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
import com.campingmapping.team4.spring.t401member.model.entity.UserName;
import com.campingmapping.team4.spring.t401member.model.entity.UserPrivacy;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t424camp.model.dao.repository.CityRepository;
import com.campingmapping.team4.spring.t424camp.model.dao.repository.TagRepository;
import com.campingmapping.team4.spring.t424camp.model.entity.City;
import com.campingmapping.team4.spring.t424camp.model.entity.Tag;

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
    
    @Autowired
    private TagRepository tagRepository;
    
    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 查看有無權限並創建
        if (alreadySetup)
            return;
        List<String> roles = Arrays.asList(
                "SUPERADMIN", "ADMIN", "CAMP", "SHOP", "FORUM", "MALL", "TEAM", "USER");
        roles.forEach(r -> createRoleIfNotFound(r));

        // 檢查有無存在生成超級管理員
        Role adminRole = roleRepository.findByName("SUPERADMIN").get();

        Optional<UserProfiles> userOptional = userRepository.findByEmail(MyConstants.SUPER_ADMIN_NAME);
        UserProfiles userProfiles;
        // Detail
        UserDetail userDetail = UserDetail.builder()
                .nickname("卍~超-級=管=理-員~卐")
                .exp(999999L)
                .leavel(999999)
                .point(99999999L)
                .registerdata(new Date())
                .build();
        // Name
        UserName userName = UserName.builder().firstname("").build();
        // Privacy
        UserPrivacy userPrivacy = UserPrivacy.builder().address("").build();
        try {
            if (userOptional.isPresent()) {
                userProfiles = userOptional.get();
                userProfiles.setUserdetail(userDetail);
                userProfiles.setUsernames(userName);
                userProfiles.setUserprivacy(userPrivacy);
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
                        .userdetail(userDetail)
                        .usernames(userName)
                        .userprivacy(userPrivacy)
                        .build();
                userProfiles.getRoles().add(adminRole);
                userRepository.save(userProfiles);

                String[] tags = { "大草原", "夜景", "親子娛樂" };
                for (int i = 0; i < tags.length; i++) {
                    createTagIfNotFound(tags[i]);
                }

                String[] citys = { "新北", "桃園", "苗栗" };
                for (int i = 0; i < citys.length; i++) {
                    createCityIfNotFound(citys[i]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        alreadySetup = true;
    }

    @Transactional
    public Role createRoleIfNotFound(String name) {
        return roleRepository.findByName(name)
                .orElseGet(() -> roleRepository.save(Role.builder().name(name).build()));
    }

    @Transactional
    public Tag createTagIfNotFound(String tagName) {
        return tagRepository.findByTagName(tagName)
                .orElseGet(() -> tagRepository.save(new Tag(tagName)));
    }

    @Transactional
    public City createCityIfNotFound(String cityName) {
        return cityRepository.findByCityName(cityName)
                .orElseGet(() -> cityRepository.save(new City(cityName)));
    }
}
