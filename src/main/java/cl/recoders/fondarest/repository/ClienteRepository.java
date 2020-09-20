package cl.recoders.fondarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.recoders.fondarest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
