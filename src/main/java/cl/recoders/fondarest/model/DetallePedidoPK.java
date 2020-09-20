package cl.recoders.fondarest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DetallePedidoPK implements Serializable {

	private static final long serialVersionUID = 3470571365026807623L;

	private Long producto_id;
	
	private Long pedido_id;
	
}
