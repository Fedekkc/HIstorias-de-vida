package entidades;

public class DetenidoNoIdentificado {
    private String apodo;
    private String descripcionSignificativa;

    public DetenidoNoIdentificado(String apodo, String descripcionSignificativa) {
        this.apodo = apodo;
        this.descripcionSignificativa = descripcionSignificativa;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getDescripcionSignificativa() {
        return descripcionSignificativa;
    }

    public void setDescripcionSignificativa(String descripcionSignificativa) {
        this.descripcionSignificativa = descripcionSignificativa;
    }
}
