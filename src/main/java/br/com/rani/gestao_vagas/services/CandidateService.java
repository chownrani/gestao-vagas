package br.com.rani.gestao_vagas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rani.gestao_vagas.exceptions.UserAlreadyExistsException;
import br.com.rani.gestao_vagas.models.Candidate;
import br.com.rani.gestao_vagas.repositories.CandidateRepository;

@Service
public class CandidateService {
    
    @Autowired
    private CandidateRepository repository;

    public Candidate create(Candidate candidate) {
        repository
            .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
            .ifPresent((user) -> {
                throw new UserAlreadyExistsException();
            });

        return repository.save(candidate);
    }
}
