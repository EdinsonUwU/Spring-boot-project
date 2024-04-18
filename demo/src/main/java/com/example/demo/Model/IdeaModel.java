package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ideas") // Corrección: convención de nombres de tablas en minúsculas
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdeaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_idea")
    private Long idIdea;
    @Column(name = "nivel")
    private Long nivel;
    @Column(name = "formato")
    private String formato;
    @Column(name = "id_funcionario_lider")
    private Long idFuncionarioLider;
    @Column(name = "id_funcionario_generador")
    private Long idFuncionarioGenerador;
    @Column(name = "id_proyecto")
    private Long idProyecto;
    // Método getter para idIdea
    public Long getIdIdea() {
        return idIdea;
    }
    
    // Método setter para idIdea (opcional, dependiendo de tus necesidades)
    public void setIdIdea(Long idIdea) {
        this.idIdea = idIdea;
    }
}
