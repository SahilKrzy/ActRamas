package model;

public class Localizacion {

	private String numero, recursoRequerido, recursoObtenido;
	private int cantidadRequerida, cantidadObtenida;
	private Jugador j;
	
	
	public Localizacion(String numero, String recursoRequerido, String cantidadRequerida,String recursoObtenido, String cantidadObtenida) {
		this.numero = numero;
		this.recursoRequerido = recursoRequerido;
		this.cantidadRequerida = Integer.parseInt(cantidadRequerida.trim());
		this.recursoObtenido = recursoObtenido;
		this.cantidadObtenida = Integer.parseInt(cantidadObtenida.trim());
		
	}


	@Override
	public String toString() {
		return "Localizacion [recursoRequerido=" + recursoRequerido + ", cantidadRequerida=" + cantidadRequerida
				+ ", recursoObtenido=" + recursoObtenido + ", cantidadObtenida=" + cantidadObtenida + ", jugador= " + getJugador() + "]";
	}


	public String getRecursoRequerido() {
		return recursoRequerido;
	}


	public void setRecursoRequerido(String recursoRequerido) {
		this.recursoRequerido = recursoRequerido;
	}


	public String getRecursoObtenido() {
		return recursoObtenido;
	}


	public void setRecursoObtenido(String recursoObtenido) {
		this.recursoObtenido = recursoObtenido;
	}


	public int getCantidadRequerida() {
		return cantidadRequerida;
	}


	public void setCantidadRequerida(int cantidadRequerida) {
		this.cantidadRequerida = cantidadRequerida;
	}


	public int getCantidadObtenida() {
		return cantidadObtenida;
	}


	public void setCantidadObtenida(int cantidadObtenida) {
		this.cantidadObtenida = cantidadObtenida;
	}


	public String getJugador() {
		String color;
		if(j == null) {
			color = "Ninguno";
		} else {
			color = j.getColor();
		}
		return color;
	}


	public void setJugador(Jugador color) {
		this.j = color;
	}
	
	
}
