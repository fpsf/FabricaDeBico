package fatec.ads.fabbico.ents;

import com.fasterxml.jackson.annotation.JsonView;
import fatec.ads.fabbico.jsonviews.ClasseViews;

import javax.persistence.*;

@Entity
public class Bico {

    @Id
    @GeneratedValue
    long id;
    
    @JsonView(ClasseViews.BicoView.class)
    private String titulo;

    @JsonView(ClasseViews.BicoView.class)
    private String pagamento;

    @JsonView(ClasseViews.BicoView.class)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }
}
