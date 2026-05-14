package br.com.rani.gestao_vagas.exceptions;

public class CompanyAlreadyExistsException extends RuntimeException {
    public CompanyAlreadyExistsException() {
        super("Company already exists");
    }
}
