package com.porfolio.arts.Interface;

import java.util.List;

import com.porfolio.arts.Entity.Persona;

public interface IPersonaService {
// traer una lista de  persona

	public List<Persona> getPersona();

	// guardar un objeto de tipo persona
	public void savePersona(Persona persona);

	// eliminar un objeto pero por Id
	public void deletePersona(Long id);

	// buscar una persona por id
	public Persona findPersona(Long id);
}
