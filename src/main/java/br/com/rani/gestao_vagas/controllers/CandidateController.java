package br.com.rani.gestao_vagas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rani.gestao_vagas.exceptions.UserAlreadyExistsException;
import br.com.rani.gestao_vagas.models.Candidate;
import br.com.rani.gestao_vagas.repositories.CandidateRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    @Autowired
    private CandidateRepository repository;

    @PostMapping("/")
    public Candidate create(@Valid @RequestBody Candidate candidate) {
        repository
        .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
        .ifPresent((user) -> {
            throw new UserAlreadyExistsException();
        });

        return repository.save(candidate);
    }
}
