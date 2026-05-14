package br.com.rani.gestao_vagas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rani.gestao_vagas.exceptions.CompanyAlreadyExistsException;
import br.com.rani.gestao_vagas.models.Company;
import br.com.rani.gestao_vagas.repositories.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository repository;

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
