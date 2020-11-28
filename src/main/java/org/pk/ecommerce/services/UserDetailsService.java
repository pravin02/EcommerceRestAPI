package org.pk.ecommerce.services;

import org.pk.ecommerce.entities.UserDetails;
import org.pk.ecommerce.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userRepository;

    public UserDetails addOrUpdateUser(UserDetails userDetails) {
        return userRepository.save(userDetails);
    }

    public Optional<UserDetails> findUserByUserId(Long userId) {
        return this.userRepository.findById(userId);
    }
}
