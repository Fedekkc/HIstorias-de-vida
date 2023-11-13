package entidades;

import java.time.LocalDate;

public class DetenidoIdentificado{
    private String nombre;
    private String DNI;
    private int lugarSecuestro;
    private LocalDate ultVezVisto;
    private String biografiaPersonal;
    private String rutaMaterialAudiovisual;


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

    public int getLugarSecuestro() {
        return lugarSecuestro;
    }

    public void setLugarSecuestro(int lugarSecuestro) {
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
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean getSobrevivio() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setTiempoEnCautiverio(int i) {
		// TODO Auto-generated method stub
		
	}

 }
