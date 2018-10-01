package fatec.ads.fabbico.repos;

import fatec.ads.fabbico.ents.Bico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoBico extends JpaRepository<Bico, Long> {

    List<Bico> findBicosByTituloContains(String titulo);

    Bico findBicoByTituloContains(String titulo);

}
