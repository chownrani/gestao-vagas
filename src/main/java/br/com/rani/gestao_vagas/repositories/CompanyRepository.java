package br.com.rani.gestao_vagas.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rani.gestao_vagas.models.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findByUsernameOrEmailOrCnpj(String username, String email, String cnpj);
}
