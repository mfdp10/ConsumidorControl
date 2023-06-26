
package com.example.dao;

import com.example.persona.Persona;
import org.springframework.data.repository.CrudRepository;


public interface IPersonaDao extends CrudRepository<Persona, Integer>{
    
}
