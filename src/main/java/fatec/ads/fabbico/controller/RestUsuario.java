package fatec.ads.fabbico.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fatec.ads.fabbico.ents.Usuario;
import fatec.ads.fabbico.repos.RepoUsuario;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUsuario {

    private static final String KEY = "spring.jwt.sec";

    private final RepoUsuario repoUsuario;

    @Autowired
    public RestUsuario(RepoUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Usuario autorizar(String token){
        // TODO Desencriptografar o token JWT.
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("userDetails", String.class);
        return repoUsuario.findUsuarioByNome(token);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Usuario cadastrar(String token){
        // TODO Desencriptografar o token JWT.
        Usuario placeholder = new Usuario();
        repoUsuario.save(placeholder);
        return repoUsuario.findUsuarioByNome(token);
    }

}
