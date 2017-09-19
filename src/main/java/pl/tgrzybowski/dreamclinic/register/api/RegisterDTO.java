package pl.tgrzybowski.dreamclinic.register.api;

import lombok.Data;

@Data
public abstract class RegisterDTO {

    private String username;
    private String password;

    private String name;
    private String surname;
}
