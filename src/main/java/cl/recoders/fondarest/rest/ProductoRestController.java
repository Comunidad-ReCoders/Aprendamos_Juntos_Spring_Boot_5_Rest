package cl.recoders.fondarest.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static cl.recoders.fondarest.rest.utils.RestPreconditions.checkNotNull;
import static cl.recoders.fondarest.rest.utils.RestPreconditions.checkSameId;

import cl.recoders.fondarest.model.Producto;
import cl.recoders.fondarest.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {
	
	@Autowired
	ProductoService service;
	
	@GetMapping(path = "/id/{id}", headers = "Accept=application/json")
	public Producto findById(@PathVariable("id") long id) {
		
		return checkNotNull(service.findById(id));
		
	}
	
	@GetMapping(path = "/list", headers = "Accept=application/json")
	public Collection<Producto> findAll() {
		
		return service.findAll();
		
	}
	
	@PostMapping(path = "/create", headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto save(@RequestBody(required = true) Producto producto) {
		
		checkNotNull(producto);
		return service.save(producto);
		
	}
	
	@PutMapping(path = "/id/{id}", headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void update(
	  @PathVariable(name = "id", required = true) long id,
	  @RequestBody(required = true) Producto producto) {
		
		checkNotNull(producto);
		checkSameId(producto, id);
		service.update(producto);
		
	}
	
	@DeleteMapping(path = "id/{id}", headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable(name = "id", required = true) long id) {
		
		checkNotNull(service.findById(id));
		service.deleteById(id);
		
	}

}
