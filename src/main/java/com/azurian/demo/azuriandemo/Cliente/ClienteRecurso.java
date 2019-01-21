package com.azurian.demo.azuriandemo.Cliente;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ClienteRecurso {
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@GetMapping("/clientes")
	public List<Cliente> retrieveAllStudents() {
		return clienteRepositorio.findAll();
	} 

	/*@RequestMapping("/")
    public String home(){
        return "Test";
    }*/
	
	@GetMapping("/clientes/{id}")
	public Cliente retrieveStudent(@PathVariable long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);

		if (!cliente.isPresent())
			throw new ClienteNotFoundException("id-" + id);

		return cliente.get();
	}

	@DeleteMapping("/clientes/{id}")
	public void deleteStudent(@PathVariable long id) {
		clienteRepositorio.deleteById(id);
	}

	@PostMapping("/clientes")
	public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente) {
		Cliente guardadoCliente = clienteRepositorio.save(cliente);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(guardadoCliente.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Object> updateCliente(@RequestBody Cliente student, @PathVariable long id) {

		Optional<Cliente> studentOptional = clienteRepositorio.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		clienteRepositorio.save(student);

		return ResponseEntity.noContent().build();
	}
}
