package br.com.rani.gestao_vagas.services;

import org.springframework.stereotype.Service;

import br.com.rani.gestao_vagas.exceptions.CompanyAlreadyExistsException;
import br.com.rani.gestao_vagas.models.Company;
import br.com.rani.gestao_vagas.repositories.CompanyRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompanyService {
    
    private final CompanyRepository repository;

    public Company create(Company company) {
        repository
            .findByUsernameOrEmailOrCnpj(
                company.getUsername(), 
                company.getEmail(),
                company.getCnpj())
            .ifPresent((entity) -> {
                throw new CompanyAlreadyExistsException();
            });
            
        return repository.save(company);
    }

}
