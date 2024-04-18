package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.ParticipanteModel;

// Corrección: Cambiar "class" por "interface" y corregir los parámetros de JpaRepository
public interface IParticipanteRepository extends JpaRepository<ParticipanteModel, Integer> {
    
}