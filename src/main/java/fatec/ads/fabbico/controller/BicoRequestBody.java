package fatec.ads.fabbico.controller;

import fatec.ads.fabbico.ents.Usuario;

import java.math.BigDecimal;

public class BicoRequestBody {

    private String titulo;

    private BigDecimal pagamento;

    private Usuario usuario;

    private String contato;

    String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    BigDecimal getPagamento() {
        return pagamento;
    }

    public void setPagamento(BigDecimal pagamento) {
        this.pagamento = pagamento;
    }

    Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
