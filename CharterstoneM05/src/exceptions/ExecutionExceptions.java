package exceptions;

import java.util.Arrays;
import java.util.List;

public class ExecutionExceptions extends Exception{

	public static final int EXCEPTION_CREATE_FILE = 0;
	public static final int EXCEPTION_READ_FILE = 1;
	public static final int EXCEPTION_WRITE_FILE = 2;
	public static final int EXCEPTION_CLOSE_FILE = 3;
	
	private int value;
	
	public ExecutionExceptions(int value) {
		this.value = value;
	}
	
	private List<String> excepcion = Arrays.asList(
			"<< Error creando el fichero >>",
			"<< Error de lectura de fichero >>",
			"<< Error de escritura de ficheros >>",
			"<< Error cerrando el fichero >>"
	);
	
	public String getMessage() {
		return excepcion.get(value);
	}
}
