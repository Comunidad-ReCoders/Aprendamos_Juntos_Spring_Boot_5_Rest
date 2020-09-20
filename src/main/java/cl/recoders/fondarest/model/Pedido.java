package cl.recoders.fondarest.model;

import java.time.LocalDateTime;
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

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Column(name = "fecha", updatable = false)
	private LocalDateTime fecha;
	
	@OneToMany(
	  mappedBy = "pedido",
	  fetch = FetchType.EAGER,
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	private Set<DetallePedido> detalles;
	
	@ManyToOne(
	  fetch = FetchType.LAZY, 
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

}
