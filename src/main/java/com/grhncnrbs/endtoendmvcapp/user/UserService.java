package com.grhncnrbs.endtoendmvcapp.user;

import com.grhncnrbs.endtoendmvcapp.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    User registerUser(RegistrationRequest registrationRequest);
    User findByEmail(String email);
}
