package com.grhncnrbs.endtoendmvcapp.registration;

import com.grhncnrbs.endtoendmvcapp.user.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;

@Data
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Collection<Role> roles;
}
