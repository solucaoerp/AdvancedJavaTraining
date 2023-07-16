package com.ibrplanner.dscommerce.services;

import com.ibrplanner.dscommerce.entities.User;
import com.ibrplanner.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userId) {
        User me = userService.authenticated(); // pega usuário autenticado
        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }
}
