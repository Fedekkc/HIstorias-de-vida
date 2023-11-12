package entidades;

public class DetenidoNoIdentificado {
   
    private String apodo;
    private String descripcionSignificativa;
    private int id_testigo = 000;

    public DetenidoNoIdentificado(String apodo, String descripcionSignificativa, int id_testigo) {
        
        this.apodo = apodo;
        this.descripcionSignificativa = descripcionSignificativa;
        this.id_testigo = id_testigo;
    }
    public DetenidoNoIdentificado(String apodo, String descripcionSignificativa) {
        
        this.apodo = apodo;
        this.descripcionSignificativa = descripcionSignificativa;
        this.id_testigo = 000;
        
    }


    public int getIdTestigo() {
    	return this.id_testigo;
    }
    public void setIdTestigo(int id) {
    	this.id_testigo = id;
    }
    
    public String getApodo() {
        return this.apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getDescripcionSignificativa() {
        return this.descripcionSignificativa;
    }

    public void setDescripcionSignificativa(String descripcionSignificativa) {
        this.descripcionSignificativa = descripcionSignificativa;
    }
}
