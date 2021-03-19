package com.DemoCrud.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DemoCrud.domain.Arbre;
import com.DemoCrud.repository.ArbreRepository;


@RestController
@RequestMapping("/api")
public class ArbresController {

	private final ArbreRepository arbreRepository;

    public ArbresController(ArbreRepository arbreRepository) {
        this.arbreRepository = arbreRepository;
    }
	
	@GetMapping("/greeting")
	void test() {
		System.out.println("working");
	}
	
	
	@GetMapping("/arbres")
    public List<Arbre> getAllArbres() {
        return arbreRepository.findAll();
    }
	
    @PostMapping("/arbres")
    public ResponseEntity<Arbre> createArbre(@RequestBody Arbre arbre) throws URISyntaxException {
    	Arbre result = arbreRepository.save(arbre);
        return new ResponseEntity<Arbre>(result, HttpStatus.OK);
    }
    
    @PutMapping("/arbres")
    public ResponseEntity<Arbre> updateArbre(@RequestBody Arbre arbre) throws URISyntaxException {
    	Arbre result = arbreRepository.save(arbre);
        return new ResponseEntity<Arbre>(result, HttpStatus.OK);
    }
    
    @DeleteMapping("/arbres/{id}")
    public ResponseEntity<Long> deleteArbre(@PathVariable Long id) {
    	arbreRepository.deleteById(id);
		return  new ResponseEntity<Long>(id, HttpStatus.OK);
    }
    
}
