package fatec.ads.fabbico.ents;

import com.fasterxml.jackson.annotation.JsonView;
import fatec.ads.fabbico.jsonviews.ClasseViews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    @JsonView(ClasseViews.UserView.class)
    long id;

    @JsonView(ClasseViews.UserView.class)
    private String nome;

    private String senha;

    @JsonView(ClasseViews.UserView.class)
    private String email;

    @JsonView(ClasseViews.UserView.class)
    private String telefone;

    @OneToMany
    private List<Bico> bicos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Bico> getBicos() {
        return bicos;
    }

    public void setBicos(List<Bico> bicos) {
        this.bicos = bicos;
    }

}
