package exceptions;

import java.util.Arrays;
import java.util.List;

public class LogicExceptions extends Exception {

	
	public static final int EXCEPTION_ACTION_I = 0;
	public static final int EXCEPTION_PARAMETER_I = 1;
	public static final int EXCEPTION_NEED_MATERIALS = 2;
	public static final int EXCEPTION_PLAY_AGAIN = 3;
	public static final int EXCEPTION_PLAYER_USED = 4;
	public static final int EXCEPTION_COMPLET = 5;
	
	
	private int value;
	private String linea;
	
	public LogicExceptions(String linea, int value) {
		this.linea = linea;
		this.value = value;
	}
	
	private List<String> excepcion = Arrays.asList(
			"<< La acción requerida es incorrecta >>",
			"<< Numero de parámetros incorrecto >>",
			"<< No se puede realizar la acción por falta de materiales >>",
			"<< El jugador no puede volver a jugar >>",
			"<< El jugador ya ha utilizado sus dos personajes >>",
			"<< Turno completado >>"

	);
	
	public String getMessage() {
		return "\nError: " + linea + "--> " + excepcion.get(value);
	}

}
