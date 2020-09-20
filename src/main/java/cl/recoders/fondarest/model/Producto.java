package cl.recoders.fondarest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(
  ignoreUnknown = true, 
  value = {
	"hibernateLazyInitializer",
	"handler",
	"categoria",
	"detalles"})
public class Producto {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@Column(name = "precio", nullable = false)
	private int precio;
	
	@ManyToOne(
	  fetch = FetchType.LAZY, 
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@OneToMany(
	  mappedBy = "producto",
	  fetch = FetchType.EAGER,
	  cascade = CascadeType.ALL)
	private Set<DetallePedido> detalles;

}
