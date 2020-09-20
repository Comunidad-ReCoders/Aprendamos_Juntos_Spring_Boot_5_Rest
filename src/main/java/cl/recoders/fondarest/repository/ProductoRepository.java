package cl.recoders.fondarest.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.recoders.fondarest.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	Collection<Producto> findByCategoria_Id(Long id);
	Collection<Producto> findByCategoria_NombreIn(Collection<String> nombres);
	Collection<Producto> findByPrecioLessThan(int precio);

}
