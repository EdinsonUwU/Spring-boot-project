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

import com.example.demo.Model.IdeaModel;
import com.example.demo.Service.IIdeaService;
import com.example.excepcion.RecursoNoEncontradoExepction;

@RestController
@RequestMapping ("/apiweb/v1/ideas") //endpoint
public class IdeaController {
    @Autowired IIdeaService ideaService;
    @PostMapping ("/")
    public ResponseEntity<String> crearIdea (@RequestBody IdeaModel idea){
        System.out.println(); // Imprimir una línea nueva antes del mensaje
        System.out.println(idea);
        System.out.println(); // Imprimir una línea nueva después del mensaje
        ideaService.guardarIdea(idea);
        return new ResponseEntity<String>(ideaService.guardarIdea(idea),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarIdeaPorId(@PathVariable int id){
        try{
            IdeaModel idea = ideaService.buscarIdeaPorId(id);
            return ResponseEntity.ok(idea);
        } catch (RecursoNoEncontradoExepction e){
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @GetMapping("/")
    public ResponseEntity <List<IdeaModel>> listarIdeas(){
        List<IdeaModel> ideas = ideaService.listarIdeas();
        return new ResponseEntity<List<IdeaModel>>(ideas,HttpStatus.OK);
    }
}
