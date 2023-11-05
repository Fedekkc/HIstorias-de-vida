package entidades;

public class DetenidoNoIdentificado {
    private int idPersona;
    private String apodo;
    private String descripcionSignificativa;

    public DetenidoNoIdentificado(int idPersona, String apodo, String descripcionSignificativa) {
        this.idPersona = idPersona;
        this.apodo = apodo;
        this.descripcionSignificativa = descripcionSignificativa;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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
