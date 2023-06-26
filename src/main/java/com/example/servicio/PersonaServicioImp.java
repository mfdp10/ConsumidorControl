package com.example.servicio;

import com.example.dao.IPersonaDao;
import com.example.persona.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServicioImp implements IPersonaServicio {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void salvar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void borrar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona localizarPersona(Persona persona) {
        return personaDao.findById(persona.getIdpersonas()).orElse(null);
    }

}
