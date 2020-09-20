package cl.recoders.fondarest.service;

import java.util.Collection;

import cl.recoders.fondarest.model.Categoria;

public interface CategoriaService {
	
	Categoria findById(long id);
	Collection<Categoria> findAll();
	Categoria save(Categoria categoria);
	Categoria update(Categoria categoria);
	void deleteById(long id);

}
