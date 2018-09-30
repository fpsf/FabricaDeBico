package fatec.ads.fabbico.controller;

import fatec.ads.fabbico.ents.Bico;
import fatec.ads.fabbico.repos.RepoBico;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe controladora com as rotas de requisições essenciais.
 *
 * Exemplo de teste para requisições POST:
 *
 * {
 * "titulo": "Vendedor de Revovi",
 * "descricao": "Vender uns revovi por 500 conto",
 * "beneficios": "50% do lucro obtido por venda e um revovi para defesa pessoal"
 * }
 *
 */
@RestController(value = "bicos")
public class RestBicos {

    private RepoBico repoBico;

    public RestBicos(RepoBico repoBico){
        this.repoBico = repoBico;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Bico> allBicos(){
        return repoBico.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBico(@RequestBody BicoRequest bicoRequest){
        Bico bico = new Bico();
        bico.setTitulo(bicoRequest.getTitulo());
        bico.setDescricao(bicoRequest.getDescricao());
        bico.setBeneficios(bicoRequest.getBeneficios());
        repoBico.save(bico);
    }

}
