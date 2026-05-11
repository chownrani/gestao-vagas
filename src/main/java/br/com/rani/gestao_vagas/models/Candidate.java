package br.com.rani.gestao_vagas.models;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Candidate {
    
    private UUID id;

    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "Username cannot have any spaces")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @Length(min = 8, max = 64)
    private String password;

    private String description;

}
