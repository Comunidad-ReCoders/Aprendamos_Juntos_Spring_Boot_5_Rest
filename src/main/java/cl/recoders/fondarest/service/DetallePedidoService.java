package cl.recoders.fondarest.service;

import java.util.Collection;

import cl.recoders.fondarest.model.DetallePedido;

public interface DetallePedidoService {
	
	DetallePedido findById(long id);
	Collection<DetallePedido> findAll();
	DetallePedido save(DetallePedido detallePedido);
	DetallePedido update(DetallePedido detallePedido);
	void deleteById(long id);

}
