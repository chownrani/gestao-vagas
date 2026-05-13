package br.com.rani.gestao_vagas.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity(name = "tb_company")
public class Company extends AbstractEntity {
    
    @NotBlank
    @Pattern(regexp = "\\S+", message = "Username cannot have any spaces")
    @Column(unique = true)
    private String username;

    @Length(min = 8, max = 64)
    private String password;

    private String cnpj;

}
