package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.ProyectoModel;


public interface IProyectoRepository extends JpaRepository<ProyectoModel, Integer>{
    
}
