package com.example.demo.Model;

import java.util.Date;

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
@Table(name = "participante") // Corrección: convención de nombres de tablas en minúsculas
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participante")
    private Long idParticipante;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "es_participante_interno")
    private boolean esParticipanteInterno;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "username")
    private String username;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "celular")
    private String celular;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha_union")
    private Date fechaUnion = new Date();
    @Column(name = "correo")
    private String correo;
    @Column(name = "id_proyecto")
    private Long idProyecto = (long) 1;
    // Método getter para idParticipante
    public Long getIdParticpante() {
        return idParticipante;
    }
    
    // Método setter para idParticipante (opcional, dependiendo de tus necesidades)
    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
    }
}
