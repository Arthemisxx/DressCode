package org.staniszewska.dresscode.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {
    private String email;
    private String password;
    private String fullName;
}
