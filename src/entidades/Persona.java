package entidades;

public class Persona {
    private Testigo testigo;

    public Persona(Testigo testigo) {
        this.testigo = testigo;
    }

    public Testigo getTestigo() {
        return testigo;
    }

    public void setTestigo(Testigo testigo) {
        this.testigo = testigo;
    }
}

