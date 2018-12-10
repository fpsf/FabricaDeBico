import fatec.ads.fabbico.Run;
import fatec.ads.fabbico.controller.RestBicos;
import fatec.ads.fabbico.ents.Usuario;
import fatec.ads.fabbico.repos.RepoBico;
import fatec.ads.fabbico.repos.RepoUsuario;
import fatec.ads.fabbico.reqbodies.BicoRequestBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Run.class)
public class BicoTest {

    @Autowired
    RepoBico repoBico;

    @Autowired
    RepoUsuario repoUsuario;

    @Test
    public void testAllBicos(){
        RestBicos restBicos = new RestBicos(repoBico);
        BicoRequestBody requestBody = new BicoRequestBody();
        Usuario usuario = repoUsuario.findUsuarioByNome("admin");
        requestBody.setId(1);
        requestBody.setTitulo("a");
        requestBody.setPagamento("b");
        requestBody.setDescricao("c");
        requestBody.setUsuario_id(usuario);
        ResponseEntity entity = restBicos.allBicos(requestBody);
        String placeholder = "";
    }

    @Test
    public void testAddBico(){
        RestBicos restBicos = new RestBicos(repoBico);
        BicoRequestBody requestBody = new BicoRequestBody();
        Usuario usuario = repoUsuario.findUsuarioByNome("admin");
        requestBody.setId(1);
        requestBody.setTitulo("a");
        requestBody.setPagamento("b");
        requestBody.setDescricao("c");
        requestBody.setUsuario_id(usuario);
        ResponseEntity entity = restBicos.addBico(requestBody);
        String placeholder = "";
    }

    @Test
    public void testDeleteBico(){
        RestBicos restBicos = new RestBicos(repoBico);
        BicoRequestBody requestBody = new BicoRequestBody();
        Usuario usuario = repoUsuario.findUsuarioByNome("admin");
        requestBody.setId(1);
        requestBody.setTitulo("a");
        requestBody.setPagamento("b");
        requestBody.setDescricao("c");
        requestBody.setUsuario_id(usuario);
        ResponseEntity entity = restBicos.addBico(requestBody);
        String placeholder = "";
        ResponseEntity delentity = restBicos.deleteBico(requestBody);
        placeholder = ".";
    }

    @Test
    public void testUpdateBico(){
        RestBicos restBicos = new RestBicos(repoBico);
        BicoRequestBody requestBody = new BicoRequestBody();
        Usuario usuario = repoUsuario.findUsuarioByNome("admin");
        requestBody.setId(1);
        requestBody.setTitulo("a");
        requestBody.setPagamento("b");
        requestBody.setDescricao("c");
        requestBody.setUsuario_id(usuario);
        ResponseEntity entity = restBicos.updateBico(requestBody);
        String placeholder = "";
    }

    // TODO Testes para os bicos.

}
