package cl.recoders.fondarest.service;

import java.util.Collection;

import cl.recoders.fondarest.model.Producto;

public interface ProductoService {
	
	Producto findById(long id);
	Collection<Producto> findAll();
	Producto save(Producto producto);
	Producto update(Producto producto);
	void deleteById(long id);

}
