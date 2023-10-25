package org.mayur.Library_Management_System.service;

import org.mayur.Library_Management_System.models.Admin;
import org.mayur.Library_Management_System.models.User;
import org.mayur.Library_Management_System.repository.AdminRepository;
import org.mayur.Library_Management_System.repository.UserRepository;
import org.mayur.Library_Management_System.request.CreateAdminRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Value("${admin.authority}")
    private String adminAuthority;

    public Admin create(CreateAdminRequest createAdminRequest) {
        Admin admin = adminRepository.findByContact(createAdminRequest.getContact());
        if(admin != null){
            return admin;
        }
        admin = createAdminRequest.to();

        User user = (User.builder().
                contact(admin.getContact())).
                password(passwordEncoder.encode(createAdminRequest.getPassword())).
                authorities(adminAuthority).
                build();
        user = userRepository.save(user);
        admin.setUser(user);
        return  adminRepository.save(admin);
    }
}
