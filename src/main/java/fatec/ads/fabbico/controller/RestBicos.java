package fatec.ads.fabbico.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fatec.ads.fabbico.ents.Bico;
import fatec.ads.fabbico.jsonviews.ClasseViews;
import fatec.ads.fabbico.repos.RepoBico;
import fatec.ads.fabbico.reqbodies.BicoRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/novobico")
@CrossOrigin
public class RestBicos {

    /*

    return new ResponseEntity(HttpStatus.FORBIDDEN);

    ████████████████████████████████████████████████████████████████▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒
    ██████████████████████████▓▓▒▒É▒▒▓█████████████▓▒▒▒▒▓▓██████████▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒
    ██████████████████████████▒▒@RH½║É▒███████████▒Fï½╠╠▒╬█████████▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒
    ███████████████████████████▒▒▒@H|╚╠╠▓█▓▓▒▒▓██▒B½╔║╠▒╬██████████▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒
    █████████████████████▓▓██████▓▒@N|[╠╠▓█▒▒▒╬█▓▒½╠╠╬▒▓██████████████▓▓▓▓▒▒▒▒▒▒▒▒▒▒
    ▓██████████████▓▓▓▓▒▒▒▒▒▓▓▓███▓▒@@╦║╠╬█▒▒╬▓█▒ï║╬╬╬████▓▓▓▓▒▒▒▒▒▒▓▓▓▓█▓▒▒▒▒▒▒▒▒▓█
    ▒▓▓▓█████████▓▓▒▒▒▒▒ÉÉÉÉÉÉÉ▒▒▓▓█▒▒@╠╠╠▓█▒╬█▓ï║╬╬▓███▓▒▒▒▒É▒ÉÉÉÉÉ▒▒▒▒▓▓▓▓▒ÉÉ▓██▓▓
    ▒▒▒▒▓▓████▓▒▒▒▒▒▒▒▒¿╠╠╠RH||½FÉ▒▒█▓▒b╠╠╢█▒▓█▒╠╬╬███▓▒▒▒▒É@╬╢ÉÉ▄▄F╬▒ÉÉ▒É▒▒▒▓██▓▓▓▓
    ▒▒▒▒▓▓███▓▓▒▓▓▓▓█▓█▓█▓▓▓▒▒@╣╦╔[╠╬▓▓▒@╠╠█▓▓█▒╬╬██▓▒╬╬▒▒╬▓█▓██▓██▓▓▓▓▌▄▒╟É▒▒▓▓▓▓▓▓
    ▒▒▒▒▓██████████▓███▓▓▓██▓▓██▓▒@╣╠▒▓█▒R╠▓▓▓▒▒▓█▓▓▒@▄██▓█▓▓▀▒▓▓█▀▀▓▓▓▓▓███▓▓▒▓▓▓▓▒
    ▒▒▒▓████████▓▓▓▓▓"▀▓▓¡,▓▓▌╠▓████▒╬ÉÉ▌R╠▓▓█▒▓█▓▒▓████▓▓▓░,╬▒▒"╓óÉR"╓╦▓▒▀▓▓▓▓▓██▓▒
    ╠É╬▓█████▓▀▓▀▄_╙╫▓▓████████████▓██▓▄╠▒╠╠▒▌╬█▓██████████▓▓█████▓[╓▒@P[╓d╠▓▀▒▒▓▓▓▓
    ║╠╠▀▓▓▓▀▒▒,_╙▓▓█████████████████████▓▓▄╦å╦▓████████▓▒▓▓FF▓▓É▓▓█▓██▄▄▓▒▀╔@███▓▓▒É
    F║║╠ÉÉ▒▄_╙▓▓▓██████▓▓▓█▓█▓▓▓███████████▌╬███████████▓█▓▌¡▌╟_▐▒▌╟▓▓╣▓█▄███▓▒▒▒ÉF╠
    H|½║╠╠É▒▓▒╬█████▓É▓▌▒▓▓▒▓▓█▓▀▀▀▀▀████▓██▒████████▓▀▀▓█▓█▓▓▓╔▐ñ▌╫▒▌╠▓████▒▒▒▒É╠╠╠
    H|½║╠╠É▒▒▓████É▒▌_▌▓╬████▓╬▒▓▓▓█▓█▄▄▀▀▓█«████▓█▓██▓▓▓▒▒▓█▓█▒█▒ƒ▒É░║▓▓██▓▒▒▒ñÉR╠╠
    H|½╠É@╬▒▓████▓ï▒╟╠▓▓████▀▄▄g▒▓▓▓▓ä▓█▓▓█▓▄▓▓█▓█▌%█▓▓▓▒µ▄▒▀██▓█▓░▓╣]▐▒▓██▓▓▒▒@ÉBR╠
    ╦╠@É@╬▒▓████▓▓j╟▓▓▓█▓█▄▒▓▀T▄▄╗╫▓█▒▄▄░███▒███▓▓▄▒▓▓▒╗▄▄░▀▓▒▓█▓█▓▓▓╔█▓▓███▓▓▒▒@ÉBB
    @@@@╬▓██████▒██▒█▓▓██▓▀▄q▒▓▀▀T▐▌▄███████▓█████▓█▄╟"T*▀╬▒▒▄"▀█▓▓▓▓▒▓█▓████▓▓▒▒@@É
    ▒▒▒▓▓████████▓▓▒▓▓██▀▄▓▀█████████████▒j▌█▐"▌█▓██████████▄▀▓▓▓██▓▓█▓▓███████▓▒▒▒ñ
    ▒▒▓██████████▒█████╬▓▀██████████▓▓██▓██▓▓█████▀▀▒╣▓▒▒▓██████▓▓▓█▓▓█▓██▓▒▒▓███▓▒▒
    ▒▓████▓▓▓▓████▓███▓▀█████████▓▒▓▓██▓█▀██░▓▓▀▓@▒▒ÉÉ╠▒▓████████▓███▓▓████▓▒ÉÉ▒▓▓▓▓
    ▓▓▀ÉÉÉ▒▒▓███████▓█▄███████████▓▒ÉÉÉ▒▓▓▒╠██▄╟ÉF]½▄╬▓████▓▓▓▓█████▓████████▒j╠╠ÉÉÉ
    Fï½╔╠╬╬▓█████████▓███▓▓▓▓▒▓▓▓▓██▓▒▒╬╬╬██▓▓██╠╠▄▓███▓▓▒ÉÉÉ╠▒▓██████▓▓▓▓████▓▒╣╠╠╠
    ╦╠@╬▒▓████████▓▓██▓█▒▒▒▒ÉÉÉ▒╬▀▓▒▒É▓▓▓▓▓█▌▓█▌É▀▀▀▀▀ÉÉÉÉÉÉÉÉÉÉ╠▓█▒█▒▒▒▒▒▒▓████▓▒╠╠
    @╬▒▓█████████▓▀▀É▒ÉÉ▓▓▓jÉBÉ╬ñÉÉÉÉÉ╬ÉÉ▀█▌_-██▀▒▄░╠╠[╠╠╠╠╠ÉÉ@╬▒▒▒ÉÉ▒▀▒▓▒▒▒▒▓█████▓
    ████████████É╔▓████▓▒╬É▓█╠╬ÉÉ╬ñÉ╠▀Ü▄█j▓__¬^█░█▌ZÉ╫[╠╠BBF╠╠▀╔▓███▓███▓É▓▒ÉÉ▒▓████
    ██▓▓████▓▓█î║█▓▒▒▒ÉÉÉ▓▓É▓█@▒ÉÉ╠╠▌µ████╔½½¡╔Ö▒█▓█▒É▌╠B╠╠╠╠f║██É▒▒▒▒▒É█▌╠▓▒▒╬███▓▓
    ██▓▓████▓▓█j║█▒▒▒▒ß▀▄╠▓▌╠█▒É╠╠B╠▀▓▓██╠µ╠█▌µµÉ███╠╟░B╠╠F╠▒I▓█▒╬▒É╠╟▒▒B█ï║▒@╣██▓╬▓
    ███▓▓███▓▓█▓╬╠▓▄▒█'╠█@╟▒╠█▄▓▒▄▄▄▄╠██╬▒▒███▓▒▒╬▓▓▒▄▄▄╣▓▓▌▌j▓█▒▌ï╟█▒▒▒╬▀╠█▒╣██▓É▓█
    ████▒▓██▓▓▒██▓▄▄▄@▒▓▓╬▓É▓██████████╬▓▓▓████▓▓▓▓███████████▄▓▌▓▒¿▀▀RÉ▒╬█▓╣▓██b▓██
    █▓▓█▓╬██▓▓▒▒É▓████▓▒▒▌É╣█▒▄µµµ▄▄▄▒▓▓▓▓██████▓▓▓▓▒▒▒▒▄╬╬É╠▓▓╬▒▓▓▓▓▓▓▓██▒▒▓██É▓██▓
    ██▓██▓Ä██▓▓▓▒▒▒▒▒▒▓▒▓▓▒É█▓▒▓▓▓▓▓█▓▓▓▓████████▓▓▓▓▓▓▓▓▓▓▓▒█▓▒▓██▒▒▒▒▒▒▒▓███▒▓██▓▒
    ██▓▓██▓Ä▓██▓▓▓▓▓▓▓▓▓▓█▓▒É▓█▓▓▒▒▓▓████████████████▓▓▓▓▓▓██▀╔▓██▓▒▒▒▒▒▒▓███▒▓██▒▒▌
    ███████▓▄▀██████████████▓ÉÉ██▒▓▓███████████████████▓███▓"╣███▓▓█▓▓▓▓███▓╬███▓▓██
    █████████▒É▓███░▄▓╬▓▓█████▒▒▀▓▓█████████████████████▓É╬▄██████▓▄▓▓▒É▒▒▄▓████████

    */

    // TODO Associar bicos a usuários.

    private RepoBico repoBico;

    @Autowired
    public RestBicos(RepoBico repoBico){
        this.repoBico = repoBico;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBico(@RequestBody BicoRequestBody bicoRequest){
        if (bicoRequest.getUsuario_id().getId() == 1){
            try{
                Bico bico = new Bico();
                // TODO Isso está certo?
                bico.setTitulo(bicoRequest.getTitulo());
                bico.setPagamento(bicoRequest.getPagamento());
                bico.setDescricao(bicoRequest.getDescricao());
                bico.setUsuario_id(bicoRequest.getUsuario_id());
                repoBico.save(bico);
                return ResponseEntity.ok().build();
            }
            catch (Exception e){
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            }
        }
        else{
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateBico(@RequestBody BicoRequestBody bicoRequest){
        if (bicoRequest.getUsuario_id().getId() == 1){
            try{
                deleteBico(bicoRequest);
                addBico(bicoRequest);
                return ResponseEntity.ok().build();
            }
            catch (Exception e){
                return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
            }
        }
        else{
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(ClasseViews.BicoView.class)
    public ResponseEntity allBicos(@RequestBody BicoRequestBody bicoRequest){
        if (bicoRequest.getUsuario_id().getId() == 1){
            // return new ResponseEntity<>(repoBico.findAll(), HttpStatus.OK);
            return ResponseEntity.ok().body(repoBico.findAll());
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteBico(@RequestBody BicoRequestBody bicoRequest){
        if (bicoRequest.getUsuario_id().getId() == 1){
            try {
                repoBico.deleteById(bicoRequest.getId());
                return ResponseEntity.ok().build();
            }
            catch (Exception e){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
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
