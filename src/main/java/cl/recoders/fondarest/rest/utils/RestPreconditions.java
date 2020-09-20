package cl.recoders.fondarest.rest.utils;

import cl.recoders.fondarest.model.Categoria;
import cl.recoders.fondarest.model.Producto;
import cl.recoders.fondarest.rest.exception.BadRequestException;
import cl.recoders.fondarest.rest.exception.ResourceNotFoundException;

public class RestPreconditions {
	
    public static <T> T checkNotNull(T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }
    
    public static void checkSameId(Categoria categoria, long id) {
    	if (categoria.getId() != id) {
    		throw new BadRequestException();
    	}
    }
    
    public static void checkSameId(Producto producto, long id) {
    	if (producto.getId() != id) {
    		throw new BadRequestException();
    	}
    }
    
}