package entidades;

import java.time.LocalDate;

public class DetenidoIdentificado {
    private String nombre;
    private String DNI;
    private String lugarSecuestro;
    private LocalDate ultVezVisto;
    private String biografiaPersonal;
    private String rutaMaterialAudiovisual;
    private String tiempoEnCautiverio;
    private String sobrevivio;

    public DetenidoIdentificado(String nombre, String DNI, String lugarSecuestro, LocalDate ultVezVisto, String biografiaPersonal, String rutaMaterialAudiovisual, String tiempoEnCautiverio, String sobrevivio) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.lugarSecuestro = lugarSecuestro;
        this.ultVezVisto = ultVezVisto;
        this.biografiaPersonal = biografiaPersonal;
        this.rutaMaterialAudiovisual = rutaMaterialAudiovisual;
        this.tiempoEnCautiverio = tiempoEnCautiverio;
        this.sobrevivio = sobrevivio;
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

    public String getTiempoEnCautiverio() {
        return tiempoEnCautiverio;
    }

    public void setTiempoEnCautiverio(String tiempoEnCautiverio) {
        this.tiempoEnCautiverio = tiempoEnCautiverio;
    }

    public String getSobrevivio() {
        return sobrevivio;
    }

    public void setSobrevivio(String sobrevivio) {
        this.sobrevivio = sobrevivio;
    }
}
