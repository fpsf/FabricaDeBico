package fatec.ads.fabbico.repos;

import fatec.ads.fabbico.ents.Bico;
import org.springframework.data.repository.CrudRepository;

public interface RepoBico extends CrudRepository<Bico, Long> {

    // List<Bico> findBicosByTituloContains(String titulo);

}
