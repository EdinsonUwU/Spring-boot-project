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

import com.example.demo.Model.ProyectoModel;
import com.example.demo.Service.IProyectoService;
import com.example.excepcion.RecursoNoEncontradoExepction;

@RestController
@RequestMapping ("/apiweb/v1/proyectos") //endpoint
public class ProyectoController {
    @Autowired IProyectoService proyectoService;
    @PostMapping ("/")
    public ResponseEntity<String> crearProyecto (@RequestBody ProyectoModel proyecto){
        System.out.println(); // Imprimir una línea nueva antes del mensaje
        System.out.println(proyecto);
        System.out.println(); // Imprimir una línea nueva después del mensaje
        proyectoService.guardarProyecto(proyecto);
        return new ResponseEntity<String>(proyectoService.guardarProyecto(proyecto),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProyectoPorId(@PathVariable int id){
        try{
            ProyectoModel proyecto = proyectoService.buscarProyectoPorId(id);
            return ResponseEntity.ok(proyecto);
        } catch (RecursoNoEncontradoExepction e){
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @GetMapping("/")
    public ResponseEntity <List<ProyectoModel>> listarProyectos(){
        List<ProyectoModel> proyectos = proyectoService.listarProyectos();
        return new ResponseEntity<List<ProyectoModel>>(proyectos,HttpStatus.OK);
    }
}
