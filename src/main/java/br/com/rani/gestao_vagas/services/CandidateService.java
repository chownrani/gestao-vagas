package br.com.rani.gestao_vagas.services;

import org.springframework.stereotype.Service;

import br.com.rani.gestao_vagas.exceptions.UserAlreadyExistsException;
import br.com.rani.gestao_vagas.models.Candidate;
import br.com.rani.gestao_vagas.repositories.CandidateRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CandidateService {
    
    private CandidateRepository repository;

    public Candidate create(Candidate candidate) {
        repository
            .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
            .ifPresent((entity) -> {
                throw new UserAlreadyExistsException();
            });

        return repository.save(candidate);
    }
}
