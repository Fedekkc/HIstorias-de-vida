package entidades;

import java.time.LocalDate;

public class DetenidoIdentificado extends Persona{
    private String nombre;
    private String DNI;
    private String lugarSecuestro;
    private LocalDate ultVezVisto;
    private String biografiaPersonal;
    private String rutaMaterialAudiovisual;
    private int tiempoEnCautiverio;
    private boolean sobrevivio;


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

    public String getLugarSecuestro() {
        return lugarSecuestro;
    }

    public void setLugarSecuestro(String lugarSecuestro) {
        this.lugarSecuestro = lugarSecuestro;
    }

    public LocalDate getUltVezVisto() {
        return ultVezVisto;
    }

    public void setUltVezVisto(LocalDate ultVezVisto) {
        this.ultVezVisto = ultVezVisto;
    }

    public String getBiografiaPersonal() {
        return biografiaPersonal;
    }

    public void setBiografiaPersonal(String biografiaPersonal) {
        this.biografiaPersonal = biografiaPersonal;
    }

    public String getRutaMaterialAudiovisual() {
        return rutaMaterialAudiovisual;
    }

    public void setRutaMaterialAudiovisual(String rutaMaterialAudiovisual) {
        this.rutaMaterialAudiovisual = rutaMaterialAudiovisual;
    }

    public int getTiempoEnCautiverio() {
        return tiempoEnCautiverio;
    }

    public void setTiempoEnCautiverio(int tiempoEnCautiverio) {
        this.tiempoEnCautiverio = tiempoEnCautiverio;
    }

    public boolean getSobrevivio() {
        return sobrevivio;
    }

    public void setSobrevivio(boolean sobrevivio) {
        this.sobrevivio = sobrevivio;
    }
}
