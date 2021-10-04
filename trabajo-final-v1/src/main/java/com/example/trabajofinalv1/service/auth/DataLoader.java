package com.example.trabajofinalv1.service.auth;

import com.example.trabajofinalv1.persistence.entities.AppUser;
import com.example.trabajofinalv1.persistence.entities.AppUserRole;
import com.example.trabajofinalv1.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public  DataLoader(IUserRepository userRepository){
        this.userRepository = userRepository;
    }


    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser("Admin", "admin", "admin@digital.com", hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("User", "user", "user@digital.com", hashedPassword2, AppUserRole.USER));
    }
}
