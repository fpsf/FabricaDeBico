package fatec.ads.fabbico.controller;

import fatec.ads.fabbico.ents.Bico;
import fatec.ads.fabbico.repos.RepoBico;
import fatec.ads.fabbico.reqbodies.BicoRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * "descricao": "Vender uns revovi por 500 conto.",
 * "beneficios": "50% do lucro obtido por venda e um revovi para defesa pessoal"
 * }
 *
 */
@RestController
@RequestMapping("/main")
public class RestBicos {

    private RepoBico repoBico;

    public RestBicos(RepoBico repoBico){
        this.repoBico = repoBico;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBico(@RequestBody BicoRequestBody bicoRequest){
        try{
            Bico bico = new Bico();
            // TODO Isso está certo?
            bico.setTitulo(bicoRequest.getTitulo());
            bico.setPagamento(bicoRequest.getPagamento());
            bico.setDescricao(bicoRequest.getDescricao());
            bico.setUsuario_id(bicoRequest.getUsuario_id());
            repoBico.save(bico);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Bico> allBicos(){
        return repoBico.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public  ResponseEntity deleteBico(@RequestBody BicoRequestBody bicoRequest){
        try {
            repoBico.deleteById(bicoRequest.getId());
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    // @RequestMapping(method = RequestMethod.PATCH)
    // pub

    /*
    @RequestMapping(method = RequestMethod.GET)
    public List<Bico> allBicos(){
        return repoBico.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBico(@RequestBody BicoRequest bicoRequest){
        try{
            Bico bico = new Bico();
            bico.setTitulo(bicoRequest.getTitulo());
            bico.setDescricao(bicoRequest.getDescricao());
            bico.setBeneficios(bicoRequest.getBeneficios());
            repoBico.save(bico);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @JsonIgnoreProperties("id")
    public Optional<Bico> oneBicoById(@PathVariable("id") long id){
        return repoBico.findById(id);
    }

    @RequestMapping(value = "/titulo", method = RequestMethod.GET)
    @JsonIgnoreProperties("titulo")
    public List<Bico> bicosByNome(String titulo) {
        return repoBico.findBicosByTituloContains(titulo);
    }
    */

}
