package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username).get();
        }catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    @Transactional(readOnly = true)
    public void validateSelfOrAdmin(Long userId) {
        User user = authenticated();

        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN"))
            throw new ForbiddenException("Access denied");
    }
}
