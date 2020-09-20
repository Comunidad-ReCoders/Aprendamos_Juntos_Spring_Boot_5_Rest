package cl.recoders.fondarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.recoders.fondarest.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
