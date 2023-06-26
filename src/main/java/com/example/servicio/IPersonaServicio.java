package com.example.servicio;

import com.example.persona.Persona;
import java.util.List;

public interface IPersonaServicio {

    public List<Persona> listaPersonas();

    public void salvar(Persona persona);

    public void borrar(Persona persona);

    public Persona localizarPersona(Persona persona);
}
