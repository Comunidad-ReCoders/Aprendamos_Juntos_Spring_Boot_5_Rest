package cl.recoders.fondarest.rest.consume;

import java.util.Collection;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.recoders.fondarest.model.Producto;

@Component
public class ProductoRestConsumer {
	
	@Autowired
	ServletContext context;
	
	public Collection<Producto> findAll() {

		//final String uri = context.getContextPath() + "/api/producto/list";
		final String uri = "http://localhost:8111/api/producto/list";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Collection<Producto>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<Collection<Producto>>()  {
				});
		
		return response.getBody();
		
	}

}
