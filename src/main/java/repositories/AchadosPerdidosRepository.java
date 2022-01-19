package repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import entities.AchadosPerdidos;

public interface AchadosPerdidosRepository extends PagingAndSortingRepository<AchadosPerdidos, Integer> {

	public Iterable<AchadosPerdidos> findByNomeContaining(String poreNome);
	public Iterable<AchadosPerdidos> findByCategoriaContaining(String categoria);

	
}
