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

import cl.recoders.fondarest.model.Categoria;
import cl.recoders.fondarest.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaRestController {
	
	@Autowired
	CategoriaService service;
	
	@GetMapping(path = "/id/{id}", headers = "Accept=application/json")
	public Categoria findById(@PathVariable(name = "id", required = true) long id) {
		
		return checkNotNull(service.findById(id));
		
	}
	
	@GetMapping(path = "/list", headers = "Accept=application/json")
	public Collection<Categoria> findAll() {
		
		return service.findAll();
		
	}
	
	@PostMapping(path = "/create", headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria save(@RequestBody(required = true) Categoria categoria) {
		
		checkNotNull(categoria);
		return service.save(categoria);
		
	}
	
	@PutMapping(path = "/id/{id}", headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void update(
	  @RequestBody(required = true) Categoria categoria,
	  @PathVariable(name = "id", required = true) long id) {
		
		checkNotNull(categoria);
		checkSameId(categoria, id);
		service.update(categoria);
		
	}
	
	@DeleteMapping(path = "/id/{id}", headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable() long id) {
		
		checkNotNull(service.findById(id));
		service.deleteById(id);
		
	}

}
