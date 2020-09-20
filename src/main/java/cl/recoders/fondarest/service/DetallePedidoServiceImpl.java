package cl.recoders.fondarest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.fondarest.model.DetallePedido;
import cl.recoders.fondarest.repository.DetallePedidoRepository;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

	@Autowired
	private DetallePedidoRepository repository;
	
	@Override
	public DetallePedido findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<DetallePedido> findAll() {
		return repository.findAll();
	}

	@Override
	public DetallePedido save(DetallePedido detallePedido) {
		return repository.save(detallePedido);
	}

	@Override
	public DetallePedido update(DetallePedido detallePedido) {
		return repository.save(detallePedido);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
