package com.ClinicaOdontologica.Clinica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = passwordEncoder.encode("1234");
        String password2 = passwordEncoder.encode("4321");

        userRepository.save(new AppUser("arivaldo","arivaldo","arivaldo@gmail.com","1234",AppUserRoles.ROLE_USER));
        userRepository.save(new AppUser("geyson","geyson","geyson@gmail.com","4321",AppUserRoles.ROLE_ADMIN));
    }
}
