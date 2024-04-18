package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ParticipanteModel;
import com.example.demo.Repository.IParticipanteRepository;
import com.example.excepcion.RecursoNoEncontradoExepction;

@Service
public class ParticipanteServiceImp implements IParticipanteService {

    @Autowired // Inyección de dependencia del repositorio
    IParticipanteRepository participanteRepository;

    @Override
    public String guardarParticipante(ParticipanteModel participante) {
        // Guardar el participante utilizando el repositorio
        participanteRepository.save(participante);
        // Devolver un mensaje de éxito
        return "El participante con el Id " + participante.getIdParticipante() + " fue creado con éxito";
    }

    @Override
    public ParticipanteModel buscarParticipantePorId(int participanteId) {
        // Buscar el participante por su Id utilizando el repositorio
        Optional<ParticipanteModel> participanteRecuperado = participanteRepository.findById(participanteId);
        // Si el participante no existe, lanzar una excepción de recurso no encontrado
        return participanteRecuperado.orElseThrow(() -> new RecursoNoEncontradoExepction(
                "Participante no encontrado con Id: " + participanteId));
    }

    @Override
    public List<ParticipanteModel> listarParticipantes() {
        // Listar todos los participantes utilizando el repositorio
        return participanteRepository.findAll();
    }
}
