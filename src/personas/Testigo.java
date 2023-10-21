package personas;

public class Testigo {

    private String nombre;
    private String DNI;
    private String testimonio;

    public Testigo(String nombre, String DNI, String testimonio) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.testimonio = testimonio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTestimonio() {
        return testimonio;
    }

    public void setTestimonio(String testimonio) {
        this.testimonio = testimonio;
    }

}
