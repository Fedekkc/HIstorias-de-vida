package entidades;

import java.time.LocalDate;

public class CCDTyE {
	
	String nombre;
	String ubicacion;
	LocalDate fechaPuestaEnMarcha = null;
	LocalDate fechaCierre = null;
	
    public CCDTyE(String nombre, String ubicacion, LocalDate fechaPuestaEnMarcha, LocalDate fechaCierre) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fechaPuestaEnMarcha = fechaPuestaEnMarcha;
        this.fechaCierre = fechaCierre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaPuestaEnMarcha() {
        return fechaPuestaEnMarcha;
    }

    public void setFechaPuestaEnMarcha(LocalDate fechaPuestaEnMarcha) {
        this.fechaPuestaEnMarcha = fechaPuestaEnMarcha;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }	
	
	

}
