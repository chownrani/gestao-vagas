package br.com.rani.gestao_vagas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rani.gestao_vagas.models.Job;
import br.com.rani.gestao_vagas.services.JobService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    
    @Autowired
    private JobService service;

    @PostMapping("/")
    public ResponseEntity<Job> create(@Valid @RequestBody Job job) {
        var response = service.create(job);
        return ResponseEntity.ok().body(response);
    }
}
