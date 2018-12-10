package fatec.ads.fabbico.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fatec.ads.fabbico.ents.Usuario;
import fatec.ads.fabbico.jsonviews.ClasseViews;
import fatec.ads.fabbico.repos.RepoUsuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

import static org.springframework.security.crypto.bcrypt.BCrypt.checkpw;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class RestUsuario {

    private final RepoUsuario repoUsuario;

    @Autowired
    public RestUsuario(RepoUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    @RequestMapping(method = RequestMethod.POST)
    @JsonView(ClasseViews.UserView.class)
    public ResponseEntity login(String nome, String senha , HttpServletResponse response){
        try{
            Usuario usuario = repoUsuario.findUsuarioByNome(nome);
            HttpHeaders headers = new HttpHeaders();
            if(Objects.equals(nome, usuario.getNome()) && checkpw(senha, usuario.getSenha())){
                // response.setHeader("Token", generateToken(usuario));
                headers.add(generateToken(usuario), "text/plain; charset=UTF-8");
                return ResponseEntity.ok().headers(headers).body(usuario);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    private static String generateToken(Usuario usuario) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        usuario.setSenha(null);
        String usuarioJson = mapper.writeValueAsString(usuario);
        return Jwts.builder().claim("userDetails", usuarioJson)
                .setSubject(usuario.getNome())
                .signWith(SignatureAlgorithm.HS512, "spring.jwt.sec")
                .compact();
    }

}
