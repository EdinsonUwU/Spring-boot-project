package com.example.demo.Service;

import java.util.List;
import com.example.demo.Model.ProyectoModel;

public interface IProyectoService {
    String guardarProyecto(ProyectoModel proyecto);
    ProyectoModel buscarProyectoPorId(int proyectoId);
    List<ProyectoModel> listarProyectos();
    //otras operaciones CRUD
}
