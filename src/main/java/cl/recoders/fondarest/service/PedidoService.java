package cl.recoders.fondarest.service;

import java.util.Collection;

import cl.recoders.fondarest.model.Pedido;

public interface PedidoService {
	
	Pedido findById(long id);
	Collection<Pedido> findAll();
	Pedido save(Pedido pedido);
	Pedido update(Pedido pedido);
	void deleteById(long id);

}
