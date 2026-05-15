package br.com.rani.gestao_vagas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rani.gestao_vagas.models.Job;

public interface JobRepository extends JpaRepository<Job, UUID> {
    
}
