package com.example.demo.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ParticipanteModel;
import com.example.demo.Service.IParticipanteService;
import com.example.excepcion.RecursoNoEncontradoExepction;

@RestController
@RequestMapping ("/apiweb/v1/participantes") //endpoint
public class ParticipanteController {
    @Autowired IParticipanteService participanteService;
    @PostMapping ("/")
    public ResponseEntity<String> crearParticipante (@RequestBody ParticipanteModel participante){
        System.out.println(); // Imprimir una línea nueva antes del mensaje
        System.out.println(participante);
        System.out.println(); // Imprimir una línea nueva después del mensaje
        participanteService.guardarParticipante(participante);
        return new ResponseEntity<String>(participanteService.guardarParticipante(participante),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarParticipantePorId(@PathVariable int id){
        try{
            ParticipanteModel participante = participanteService.buscarParticipantePorId(id);
            return ResponseEntity.ok(participante);
        } catch (RecursoNoEncontradoExepction e){
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @GetMapping("/")
    public ResponseEntity <List<ParticipanteModel>> listarParticipantes(){
        List<ParticipanteModel> participantes = participanteService.listarParticipantes();
        return new ResponseEntity<List<ParticipanteModel>>(participantes,HttpStatus.OK);
    }
}
