import fatec.ads.fabbico.Run;
import fatec.ads.fabbico.controller.RestUsuario;
import fatec.ads.fabbico.repos.RepoUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
// @WebMvcTest(value = RestUsuario.class, secure = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Run.class)
public class LoginRestTest {

    @Autowired
    private RepoUsuario repoUsuario;

    @Test
    public void loginOk(){
        RestUsuario controller = new RestUsuario(repoUsuario);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ResponseEntity responseEntity = controller.login("guest", "guest", response);
        String placeholder = "";
    }

}
