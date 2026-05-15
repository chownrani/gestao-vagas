package br.com.rani.gestao_vagas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rani.gestao_vagas.models.Job;
import br.com.rani.gestao_vagas.repositories.JobRepository;

@Service
public class JobService {
    
    @Autowired
    private JobRepository repository;

    public Job create(Job job) {
        return repository.save(job);
    }
}
