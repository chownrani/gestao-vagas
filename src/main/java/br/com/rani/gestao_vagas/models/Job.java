package br.com.rani.gestao_vagas.models;

import br.com.rani.gestao_vagas.models.enumerations.JobLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity(name = "tb_job")
public class Job extends AbstractEntity {
    
    @NotNull(message = "Job level is required")
    @Enumerated(EnumType.STRING)
    private JobLevel level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

}
