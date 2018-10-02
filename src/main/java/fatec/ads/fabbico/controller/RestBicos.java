package fatec.ads.fabbico.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import fatec.ads.fabbico.ents.Bico;
import fatec.ads.fabbico.repos.RepoBico;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe controladora com as rotas de requisições essenciais.
 *
 * Exemplo de teste para requisições POST:
 *
 * {
 * "titulo": "Vendedor de Revovi",
 * "descricao": "Vender uns revovi por 500 conto.",
 * "beneficios": "50% do lucro obtido por venda e um revovi para defesa pessoal"
 * }
 *
 */
@RestController
public class RestBicos {

    private RepoBico repoBico;

    public RestBicos(RepoBico repoBico){
        this.repoBico = repoBico;
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(Bico.DefaultView.class)
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @JsonIgnoreProperties("id")
    @JsonView(Bico.OneView.class)
    public Optional<Bico> oneBicoById(@PathVariable("id") long id){
        return repoBico.findById(id);
    }

    @RequestMapping(value = "/titulo", method = RequestMethod.GET)
    @JsonIgnoreProperties("titulo")
    @JsonView(Bico.TSView.class)
    public List<Bico> bicosByNome(String titulo) {
        return repoBico.findBicosByTituloContains(titulo);
    }

    /*
    public static class Views{
        static class Todos{}
        static class Alt{}
    }
    */

    /*
    @RequestMapping(value = "/titulo", method = RequestMethod.GET)
    public String bicosByNome(String titulo) {
        List<Bico> opt = repoBico.findBicosByTituloContains(titulo);
        StringBuilder ret = new StringBuilder("[\n");
        for(int i = 0; i < opt.size(); i++){
            ret.append("{\"id\":\"").append(opt.get(i).getId()).append("\",\"descricao\":\"").append(opt.get(i).getDescricao()).append("\",\"beneficios\":\"").append(opt.get(i).getBeneficios()).append("\"}");
            if (i != opt.size() - 1){
                ret.append(",");
            }
            ret.append("\n");
        }
        ret.append("]");
        return ret.toString();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String oneBico(@PathVariable("id") long id) {
        Optional<Bico> opt = repoBico.findById(id);
        return "{\"titulo\":\""+opt.get().getTitulo()+"\",\"descricao\":\""+opt.get().getDescricao()+"\",\"beneficios\":\""+opt.get().getBeneficios()+"\"}";
    }
    */

}
