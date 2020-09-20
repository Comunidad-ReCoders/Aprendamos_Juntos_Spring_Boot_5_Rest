package cl.recoders.fondarest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.fondarest.model.Pedido;
import cl.recoders.fondarest.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Override
	public Pedido findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<Pedido> findAll() {
		return repository.findAll();
	}

	@Override
	public Pedido save(Pedido pedido) {
		return repository.save(pedido);
	}

	@Override
	public Pedido update(Pedido pedido) {
		return repository.save(pedido);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
