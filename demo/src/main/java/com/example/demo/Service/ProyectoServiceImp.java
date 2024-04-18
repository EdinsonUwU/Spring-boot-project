package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ProyectoModel;
import com.example.demo.Repository.IProyectoRepository;
import com.example.excepcion.RecursoNoEncontradoExepction;

@Service
public class ProyectoServiceImp implements IProyectoService{
    
    @Autowired // Inyección de dependencia del repositorio
    IProyectoRepository proyectoRepository;

    @Override
    public String guardarProyecto(ProyectoModel proyecto) {
        // Guardar el proyecto utilizando el repositorio
        proyectoRepository.save(proyecto);
        // Devolver un mensaje de éxito
        return "El proyecto con el Id " + proyecto.getIdProyecto() + " fue creado con éxito";
    }

    @Override
    public ProyectoModel buscarProyectoPorId(int proyectoId) {
        // Buscar el proyecto por su Id utilizando el repositorio
        Optional<ProyectoModel> proyectoRecuperado = proyectoRepository.findById(proyectoId);
        // Si el proyecto no existe, lanzar una excepción de recurso no encontrado
        return proyectoRecuperado.orElseThrow(() -> new RecursoNoEncontradoExepction(
                "Proyecto no encontrado con Id: " + proyectoId));
    }

    @Override
    public List<ProyectoModel> listarProyectos() {
        // Listar todos los proyectos utilizando el repositorio
        return proyectoRepository.findAll();
    }
}
