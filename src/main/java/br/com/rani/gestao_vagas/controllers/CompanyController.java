package br.com.rani.gestao_vagas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rani.gestao_vagas.models.Company;
import br.com.rani.gestao_vagas.services.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {
    
    private CompanyService service;

    @PostMapping("/")
    public ResponseEntity<Object> create(
        @Valid @RequestBody Company company) {
            try {
                var response = service.create(company);
                return ResponseEntity.ok().body(response);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }

}
