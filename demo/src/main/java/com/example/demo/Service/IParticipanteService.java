package com.example.demo.Service;

import java.util.List;
import com.example.demo.Model.ParticipanteModel;

public interface IParticipanteService {
    String guardarParticipante(ParticipanteModel participante);
    ParticipanteModel buscarParticipantePorId(int participanteId);
    List<ParticipanteModel> listarParticipantes();
    //otras operaciones CRUD
}
