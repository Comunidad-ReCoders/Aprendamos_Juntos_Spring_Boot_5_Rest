package cl.recoders.fondarest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_pedido")
@IdClass(value = DetallePedidoPK.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {
	
	@Id
	@Column(name = "producto_id")
	private Long producto_id;
	
	@Id
	@Column(name = "pedido_id")
	private Long pedido_id;
	
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@ManyToOne(
	  fetch = FetchType.LAZY, 
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	@JoinColumn(name = "producto_id", insertable = false, updatable = false)
	private Producto producto;
	
	@ManyToOne(
	  fetch = FetchType.LAZY, 
	  cascade = {
	    CascadeType.DETACH,
	    CascadeType.MERGE,
	    CascadeType.PERSIST,
	    CascadeType.REFRESH})
	@JoinColumn(name = "pedido_id", insertable = false, updatable = false)
	private Pedido pedido;

}
