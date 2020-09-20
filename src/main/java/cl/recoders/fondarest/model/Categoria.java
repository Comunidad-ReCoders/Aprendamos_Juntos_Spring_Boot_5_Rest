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
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(
  ignoreUnknown = true, 
  value = {
	"hibernateLazyInitializer",
	"handler",
	"categoriaSuperior"})
public class Categoria {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 50, nullable = false, unique = true)
	private String nombre;
	
	@ManyToOne(
	  fetch = FetchType.LAZY, 
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	@JoinColumn(name = "categoria_superior", nullable = true)
	private Categoria categoriaSuperior;
	
	@OneToMany(
	  mappedBy = "categoriaSuperior",
	  fetch = FetchType.EAGER, 
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	private Set<Categoria> subcategorias;
	
	@OneToMany(
	  mappedBy = "categoria",
	  fetch = FetchType.EAGER,
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	private Set<Producto> productos;

}
