import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fatec.ads.fabbico.ents.Usuario;
import fatec.ads.fabbico.repos.RepoUsuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.springframework.security.crypto.bcrypt.BCrypt.checkpw;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    private RepoUsuario repoUsuario;

    @Test
    public void loginOk(){
        String nome = "guest";
        String senha = "guest";
        Usuario usuario = repoUsuario.findUsuarioByNome(nome);
        // response.setHeader("Token", generateToken(usuario));
        assert Objects.equals(nome, usuario.getNome()) && checkpw(senha, usuario.getSenha());
    }

    @Test
    public void tokenOk() throws JsonProcessingException {
        Usuario usuario = repoUsuario.findUsuarioByNome("guest");
        System.out.println(generateToken(usuario));
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
