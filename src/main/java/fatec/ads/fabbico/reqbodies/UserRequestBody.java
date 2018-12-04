package fatec.ads.fabbico.reqbodies;

import fatec.ads.fabbico.ents.Bico;

import java.util.List;

public class UserRequestBody {

    private long id;

    private String nome;

    private String senha;

    private String token;

    private String email;

    private String telefone;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
