package br.com.rani.gestao_vagas.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "password")
@Entity(name = "tb_candidate")
public class Candidate extends AbstractEntity {

    @NotBlank
    @Pattern(regexp = "\\S+", message = "Username cannot have any spaces")
    @Column(unique = true)
    private String username;

    @Length(min = 8, max = 64)
    private String password;

    private String cpf;

}

