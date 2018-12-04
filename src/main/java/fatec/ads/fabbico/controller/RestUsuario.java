package fatec.ads.fabbico.controller;

import fatec.ads.fabbico.ents.Usuario;
import fatec.ads.fabbico.repos.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.security.crypto.bcrypt.BCrypt.checkpw;

@RestController
public class RestUsuario {

    private static final String KEY = "spring.jwt.sec";

    private final RepoUsuario repoUsuario;

    @Autowired
    public RestUsuario(RepoUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(String nome, String pass){
        // TODO Desencriptografar o token JWT.
        Usuario usuario = repoUsuario.findUsuarioByNome(nome);
        if(Objects.equals(nome, usuario.getNome()) && checkpw(pass, usuario.getSenha())){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Usuario cadastrar(String token){
        // TODO Desencriptografar o token JWT.
        Usuario placeholder = new Usuario();
        repoUsuario.save(placeholder);
        return repoUsuario.findUsuarioByNome(token);
    }

}
