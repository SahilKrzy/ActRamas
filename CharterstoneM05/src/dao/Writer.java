package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.ExecutionExceptions;

public class Writer {

	private FileWriter fr;
	private File archivo;
	private BufferedWriter br;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Writer(String archivo) throws ExecutionExceptions {//constructor		
		fr = null;
		try {
			fr = new FileWriter(archivo);
		} catch (IOException e) {
			throw new ExecutionExceptions(ExecutionExceptions.EXCEPTION_CREATE_FILE);
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public String writeChar(String dato) {//escribir por caracter
//		try {
//			fr.write(dato);
//		} catch (IOException e) {
//			System.out.println("ERROR al abrir o escribir en el archivo: " + e.getMessage());
//		}
//		return null;
//	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String escribirLinea(String dato) throws ExecutionExceptions {//escribir por linea
		try {
			fr.write(dato);
		} catch (IOException e) {
//			System.out.println("ERROR al abrir o escribir en el archivo: " + e.getMessage());
			throw new ExecutionExceptions(ExecutionExceptions.EXCEPTION_WRITE_FILE);
		}
		return null;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void close() throws ExecutionExceptions {//cerrar
		try {
			if (fr != null) {
				fr.close();
			}
		} catch (IOException e) {
//			System.out.println("ERROR al cerrar el archivo: " + e.getMessage());
			throw new ExecutionExceptions(ExecutionExceptions.EXCEPTION_CLOSE_FILE);
		}
	}
}
