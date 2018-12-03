package fatec.ads.fabbico.controller;

import java.math.BigDecimal;

public class BicoRequestBody {

    private long id;

    private String titulo;

    private BigDecimal pagamento;

    private String email;

    long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
