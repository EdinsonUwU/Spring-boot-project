package com.example.demo.Service;

import java.util.List;
import com.example.demo.Model.IdeaModel;

public interface IIdeaService {
    String guardarIdea(IdeaModel idea);
    IdeaModel buscarIdeaPorId(int ideaId);
    List<IdeaModel> listarIdeas();
    //otras operaciones CRUD
}
