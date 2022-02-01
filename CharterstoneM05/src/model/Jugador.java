package model;

public class Jugador {

	private int numero, cantidadCarbon, cantidadTrigo, cantidadMadera, cantidadMoneda, cantidadPunto;
	private String color;
	
	
	public Jugador(String color, String cantidadCarbon, String cantidadTrigo, String cantidadMadera) {
		this.color = color;
		this.cantidadCarbon = Integer.parseInt(cantidadCarbon);
		this.cantidadTrigo = Integer.parseInt(cantidadTrigo);
		this.cantidadMadera = Integer.parseInt(cantidadMadera);
		this.cantidadMoneda = 0;
		this.cantidadPunto = 0;
	}


	@Override
	public String toString() {
		return "Jugador [color=" + color + ", cantidadPunto=" + cantidadPunto + ", cantidadMadera=" + cantidadMadera
				+ ", cantidadCarbon=" + cantidadCarbon + ", cantidadTrigo=" + cantidadTrigo + ", cantidadMoneda="
				+ cantidadMoneda + "]";
	}


	public int getCantidadCarbon() {
		return cantidadCarbon;
	}


	public void setCantidadCarbon(int cantidadCarbon) {
		this.cantidadCarbon = cantidadCarbon;
	}


	public int getCantidadTrigo() {
		return cantidadTrigo;
	}


	public void setCantidadTrigo(int cantidadTrigo) {
		this.cantidadTrigo = cantidadTrigo;
	}


	public int getCantidadMadera() {
		return cantidadMadera;
	}


	public void setCantidadMadera(int cantidadMadera) {
		this.cantidadMadera = cantidadMadera;
	}


	public int getCantidadMoneda() {
		return cantidadMoneda;
	}


	public void setCantidadMoneda(int cantidadMoneda) {
		this.cantidadMoneda = cantidadMoneda;
	}


	public int getCantidadPunto() {
		return cantidadPunto;
	}


	public void setCantidadPunto(int cantidadPunto) {
		this.cantidadPunto = cantidadPunto;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setTrigo(int cantidadObtenido) {
		this.cantidadTrigo += cantidadObtenido;
	}
	
	public void setMadera(int cantidadObtenido) {
		this.cantidadMadera += cantidadObtenido;
	}
	
	public void setCarbon(int cantidadObtenido) {
		this.cantidadCarbon += cantidadObtenido;
	}
	
	public void setMonedas(int cantidadObtenido) {
		this.cantidadMoneda += cantidadObtenido;
	}
	
	
	
}
