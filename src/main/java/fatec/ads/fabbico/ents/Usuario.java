package fatec.ads.fabbico.ents;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Usuario {

    /*
    @Id
    @GeneratedValue
    long id;
    */

    @Id
    private String nome;

    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Bico> bicos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Bico> getBicos() {
        return bicos;
    }

    public void setBicos(List<Bico> bicos) {
        this.bicos = bicos;
    }
}
