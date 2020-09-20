package cl.recoders.fondarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.recoders.fondarest.rest.consume.ProductoRestConsumer;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	ProductoRestConsumer consumer;
	
	@GetMapping("/list")
	public ModelAndView findAll() {
		
		ModelAndView mav = new ModelAndView("productos");
		mav.addObject("productos", consumer.findAll());
		return mav;
		
	}

	
	
}
