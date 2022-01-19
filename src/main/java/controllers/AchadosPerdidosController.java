package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entities.AchadosPerdidos;
import repositories.AchadosPerdidosRepository;

@RestController
@RequestMapping("/api/achadosperdidos")
public class AchadosPerdidosController {
	
	@Autowired
	private AchadosPerdidosRepository achadosPerdidosRepository;
	

	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}) 
	public @ResponseBody AchadosPerdidos salvarProduto(@Valid AchadosPerdidos achadosPerdidos) {
		achadosPerdidosRepository.save(achadosPerdidos);
		return achadosPerdidos;
	}
	
	@GetMapping
	public Iterable<AchadosPerdidos> obterTodosAchados() {
		return achadosPerdidosRepository.findAll();
	}
	
	
		@GetMapping("nome/{porNome}")
		public Iterable<AchadosPerdidos> obterAchadosPerdidosPorNome(@PathVariable String porNome) {
			return achadosPerdidosRepository.findByNomeContaining(porNome);
		}
		
		@GetMapping("nome/{categoria}")
		public Iterable<AchadosPerdidos> obterAchadosPerdidosPorCategoria
		(@PathVariable String categoria) {
			return achadosPerdidosRepository.findByNomeContaining(categoria);
		}
		
		

}
