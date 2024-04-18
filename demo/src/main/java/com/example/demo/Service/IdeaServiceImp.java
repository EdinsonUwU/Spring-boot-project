package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.IdeaModel;
import com.example.demo.Repository.IIdeaRepository;
import com.example.excepcion.RecursoNoEncontradoExepction;

@Service
public class IdeaServiceImp implements IIdeaService {

    @Autowired // Inyección de dependencia del repositorio
    IIdeaRepository ideaRepository;

    @Override
    public String guardarIdea(IdeaModel idea) {
        // Guardar el idea utilizando el repositorio
        ideaRepository.save(idea);
        // Devolver un mensaje de éxito
        return "La idea con el Id " + idea.getIdIdea() + " fue creado con éxito";
    }

    @Override
    public IdeaModel buscarIdeaPorId(int ideaId) {
        // Buscar el idea por su Id utilizando el repositorio
        Optional<IdeaModel> ideaRecuperado = ideaRepository.findById(ideaId);
        // Si el idea no existe, lanzar una excepción de recurso no encontrado
        return ideaRecuperado.orElseThrow(() -> new RecursoNoEncontradoExepction(
                "Idea no encontrado con Id: " + ideaId));
    }

    @Override
    public List<IdeaModel> listarIdeas() {
        // Listar todos los ideas utilizando el repositorio
        return ideaRepository.findAll();
    }
}
