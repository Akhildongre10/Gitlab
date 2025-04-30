package com.armory.WeaponVault.security;

import com.armory.WeaponVault.entity.SuperAdmin;
import com.armory.WeaponVault.repository.SuperAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService{

    private final SuperAdminRepository superAdminRepository;

    @Autowired
    public UserService(SuperAdminRepository superAdminRepository) {
        this.superAdminRepository = superAdminRepository;
    }

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public SuperAdmin saveUser(SuperAdmin superAdmin) {

        superAdmin.setPassword(encoder.encode(superAdmin.getPassword()));
        return superAdminRepository.save(superAdmin);
    }

    public SuperAdmin updateToken(SuperAdmin superAdmin){
        return  superAdminRepository.save(superAdmin);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SuperAdmin superAdmin = superAdminRepository.findByEmail(username);

        if (superAdmin == null) {
            throw new UsernameNotFoundException("Error 404");
        } else {
            return new UserPrincipal(superAdmin);
        }
    }

    public boolean authenticate(String username, String rawPassword) {
        // Find user by username in the database
        SuperAdmin superAdmin = superAdminRepository.findByEmail(username);

        if (superAdmin == null) {
            return false; // User not found
        }
        return encoder.matches(rawPassword, superAdmin.getPassword());
    }
    public SuperAdmin findByToken(String token){
        return superAdminRepository.findByToken(token);
    }

    public Optional<SuperAdmin>  findById(Long id) {

        return superAdminRepository.findById(id);
    }

}

