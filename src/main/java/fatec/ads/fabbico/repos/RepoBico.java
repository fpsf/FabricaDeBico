package fatec.ads.fabbico.repos;

import fatec.ads.fabbico.ents.Bico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoBico extends JpaRepository<Bico, String> {

    // List<Bico> findBicosByTituloContains(String titulo);

}
