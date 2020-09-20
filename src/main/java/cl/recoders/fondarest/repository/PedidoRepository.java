package cl.recoders.fondarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.recoders.fondarest.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
