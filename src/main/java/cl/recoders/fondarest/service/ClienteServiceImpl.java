package cl.recoders.fondarest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.fondarest.model.Cliente;
import cl.recoders.fondarest.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
