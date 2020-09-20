package cl.recoders.fondarest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.fondarest.model.Producto;
import cl.recoders.fondarest.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public Producto findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<Producto> findAll() {
		return repository.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
