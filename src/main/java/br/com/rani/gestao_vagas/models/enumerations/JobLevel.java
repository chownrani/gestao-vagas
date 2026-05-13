package br.com.rani.gestao_vagas.models.enumerations;


public enum JobLevel {
    
    JUNIOR("Junior"),
    MID("MID"),
    SENIOR("Senior");

    private String description;

    JobLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
