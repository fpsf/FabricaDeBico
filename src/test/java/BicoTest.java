import fatec.ads.fabbico.Run;
import fatec.ads.fabbico.repos.RepoBico;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Run.class)
public class BicoTest {

    @Autowired
    RepoBico repoBico;

    // TODO Testes para os bicos.

}
