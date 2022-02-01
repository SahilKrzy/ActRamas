package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import exceptions.ExecutionExceptions;

public class Reader {

	private FileReader fr;
	private File archivo;
	private BufferedReader br;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Reader(String leer) throws ExecutionExceptions {// constructor
		archivo = new File(leer);
		fr = null;
		br = null;
		try {
			fr = new FileReader(leer);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
//			System.out.println("No se ha encontrado el archivo");
			throw new ExecutionExceptions(ExecutionExceptions.EXCEPTION_CREATE_FILE);
		}

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public int leerChar() {//leer por caracter
//		try {
//			return fr.read();
//		} catch (IOException e) {
//			System.out.println("ERROR al abrir o leer el archivo: " + e.getMessage());
//		}
//		return -1;
//	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String leer() throws ExecutionExceptions {// leer por linea
		try {
			return br.readLine();
		} catch (IOException e) {
//			System.out.println("ERROR al abrir o leer el archivo: " + e.getMessage());
			throw new ExecutionExceptions(ExecutionExceptions.EXCEPTION_READ_FILE);
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void close() throws ExecutionExceptions {// cerrar
		try {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
//			System.out.println("ERROR al cerrar el archivo: " + e.getMessage());
			throw new ExecutionExceptions(ExecutionExceptions.EXCEPTION_CLOSE_FILE);
		}
	}
}
