package br.com.rani.gestao_vagas.models;

import br.com.rani.gestao_vagas.models.enumerations.JobLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumeratedValue;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_job")
public class Job extends AbstractEntity {
    
    @EnumeratedValue
    private JobLevel level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

}
