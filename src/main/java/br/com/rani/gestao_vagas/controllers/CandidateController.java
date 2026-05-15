package br.com.rani.gestao_vagas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rani.gestao_vagas.models.Candidate;
import br.com.rani.gestao_vagas.services.CandidateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    private CandidateService service;

    @PostMapping("/")
    public ResponseEntity<Object> create(
        @Valid @RequestBody Candidate candidate) {
            try {
                var response = service.create(candidate);
                return ResponseEntity.ok().body(response);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }
}
