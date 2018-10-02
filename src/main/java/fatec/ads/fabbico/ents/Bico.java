package fatec.ads.fabbico.ents;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bico {

    public interface DefaultView{}

    public interface OneView{}

    public interface TSView{}

    @Id
    @JsonView({DefaultView.class,TSView.class})
    @GeneratedValue
    long id;

    @JsonView({DefaultView.class,OneView.class,TSView.class})
    private String titulo;

    @JsonView({DefaultView.class,OneView.class})
    private String descricao;

    @JsonView({DefaultView.class,OneView.class})
    private String beneficios;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
}
