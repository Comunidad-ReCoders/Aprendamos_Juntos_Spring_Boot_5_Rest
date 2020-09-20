package cl.recoders.fondarest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.fondarest.model.Categoria;
import cl.recoders.fondarest.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public Categoria findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<Categoria> findAll() {
		return repository.findAll();
	}

	@Override
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}

	@Override
	public Categoria update(Categoria categoria) {
		return repository.save(categoria);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
