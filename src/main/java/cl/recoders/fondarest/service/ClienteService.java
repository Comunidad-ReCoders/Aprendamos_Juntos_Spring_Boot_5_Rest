package cl.recoders.fondarest.service;

import java.util.Collection;

import cl.recoders.fondarest.model.Cliente;

public interface ClienteService {
	
	Cliente findById(long id);
	Collection<Cliente> findAll();
	Cliente save(Cliente cliente);
	Cliente update(Cliente cliente);
	void deleteById(long id);

}
