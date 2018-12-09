package fatec.ads.fabbico.repos;

import fatec.ads.fabbico.ents.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RepoUsuario extends CrudRepository<Usuario, Long> {

    // admin (12r) == $2y$12$ojkU6JKD6HCB0Igd9Iup/ee9V.apjGm6iw3GvNfeuUppmlCnapo4q
    // guest (12r) == $2y$12$mmqoK.Ce3MTK0arsFT2b3OBx1UixntbfbEUKqtUf2ez3IOjzYdDF6

    Usuario findUsuarioByNome(String nome);

}
