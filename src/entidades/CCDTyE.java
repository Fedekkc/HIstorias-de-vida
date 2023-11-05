package entidades;

import java.time.LocalDate;

import java.util.ArrayList;

public class CCDTyE {
	private int ID;
	private String nombre;
	private String ubicacion;
	private LocalDate fechaPuestaEnMarcha = null;
	private LocalDate fechaCierre = null;
	private ArrayList<Integer> fuerzasAlMando = new ArrayList<Integer>();
	

    
    public int getID() {
    	return ID; 
    }
    
    public void setID(int ID) {
    	this.ID = ID;
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

	public ArrayList<Integer> getFuerzasAlMando() {
		return fuerzasAlMando;
	}

	public void setFuerzasAlMando(ArrayList<Integer> fuerzasAlMando) {
		this.fuerzasAlMando = fuerzasAlMando;
	}	
	
	

}
