package manager;


import java.util.ArrayList;


import dao.Reader;
import dao.Writer;
import exceptions.ExecutionExceptions;
import exceptions.LogicExceptions;
import model.Jugador;
import model.Localizacion;

public class Manager {
	private static Manager manager;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Localizacion> ubicaciones;
	private String linea;
	private Reader r;
	private boolean letra;
	private int played;
	private Writer w;

	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager();
		}
		return manager;
	}

	public void init() throws Exception {

		r = new Reader("entrada.txt");
		w = new Writer("sahilSalida.txt");
		jugadores = new ArrayList<Jugador>();
		ubicaciones = new ArrayList<Localizacion>();

		try {
			while (!(linea = r.leer()).equals("##")) {
				jugadores.add(new Jugador(linea.split(" ")[1], linea.split(" ")[2], linea.split(" ")[3],
						linea.split(" ")[4]));
			}
			while (!(linea = r.leer()).equals("##")) {
				ubicaciones.add(new Localizacion(linea.split(" ")[0], linea.split(" ")[1], linea.split(" ")[2],
						linea.split(" ")[4], linea.split(" ")[5]));
			}
		} catch (ExecutionExceptions e1) {
			System.out.println(e1.getMessage());
		}
		
		accion(linea);
		w.close();
	}

	private void accion(String linea) throws Exception {
		while ((linea = r.leer()) != null) {
			try {
				if (!linea.equals("I") && !letra) {
					throw new LogicExceptions(linea, LogicExceptions.EXCEPTION_ACTION_I);
				}
				switch (linea.split(" ")[0]) {
					case "S":
						showJugadores();
						break;
					case "I":
						w.escribirLinea("\nINICIANDO PARTIDA");
						letra = true;
						break;
					case "M":
						m(linea);
						break;
					case "R":
						r(linea);
						break;
					case "L":
						l();
						break;
				}
			} catch (LogicExceptions e) {
				w.escribirLinea(e.getMessage());
				System.out.println("Error: " + linea + "--> " + e.getMessage());

			}
		}
	}

	private void l() throws ExecutionExceptions {
		for (int i = 0; i < ubicaciones.size(); i++) {
			w.escribirLinea("\n\t" + ubicaciones.get(i).toString());
		}
	}

	private void r(String linea) {
		int num = Integer.parseInt(linea.split(" ")[1]) - 1;

		String color = jugadores.get(num).getColor();

		for (int i = 0; i < ubicaciones.size(); i++) {
			String jugador = ubicaciones.get(i).getJugador();

			if (color == jugador) {
				ubicaciones.get(i).setJugador(null);
			}
		}
	}

	private void m(String linea) throws LogicExceptions {
		int p = Integer.parseInt(linea.split(" ")[1]) - 1, u = Integer.parseInt(linea.split(" ")[2]) - 1, aux = 0;

		if (played == p) {
			throw new LogicExceptions(linea, LogicExceptions.EXCEPTION_PLAY_AGAIN);
		}
		played = p;
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String player = jugadores.get(p).getColor();
		for (int i = 0; i < ubicaciones.size(); i++) {
			if ((ubicaciones.get(i).getJugador() != null) && (ubicaciones.get(i).getJugador().contains(player))) {
				aux++;
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (aux > 2) {
			throw new LogicExceptions(linea, LogicExceptions.EXCEPTION_PLAYER_USED);
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String mats = ubicaciones.get(u).getRecursoRequerido();
		int needed = 0;
		boolean check = false;

		switch (mats) {
		case "T":
			needed = jugadores.get(p).getCantidadTrigo();
			check = checker(u, p, needed);
			if (check) {
				jugadores.get(p).setTrigo(((needed) - (ubicaciones.get(u).getCantidadRequerida())));
			}
			break;
		case "M":
			needed = jugadores.get(p).getCantidadMadera();
			check = checker(u, p, needed);
			if (check) {
				jugadores.get(p).setMadera(((needed) - (ubicaciones.get(u).getCantidadRequerida())));
			}
			break;
		case "X":
			needed = jugadores.get(p).getCantidadMoneda();
			check = checker(u, p, needed);
			if (check) {
				jugadores.get(p).setMonedas(((needed) - (ubicaciones.get(u).getCantidadRequerida())));
			}
			break;
		case "C":
			needed = jugadores.get(p).getCantidadCarbon();
			check = checker(u, p, needed);
			if (check) {
				jugadores.get(p).setCarbon(((needed) - (ubicaciones.get(u).getCantidadRequerida())));
			}
			break;
		}
		throw new LogicExceptions(linea, LogicExceptions.EXCEPTION_COMPLET);
	}

	private boolean checker(int u, int p, int needed) throws LogicExceptions {
		if (ubicaciones.get(u).getCantidadRequerida() <= needed) {
			ubicaciones.get(u).setJugador(jugadores.get(p));
			String materials = ubicaciones.get(u).getRecursoObtenido();

			switch (materials) {
			case "T":
				jugadores.get(p).setTrigo(ubicaciones.get(u).getCantidadObtenida());
				break;
			case "M":
				jugadores.get(p).setMadera(ubicaciones.get(u).getCantidadObtenida());
				break;
			case "X":
				jugadores.get(p).setMonedas(ubicaciones.get(u).getCantidadObtenida());
				break;
			case "C":
				jugadores.get(p).setCarbon(ubicaciones.get(u).getCantidadObtenida());
				break;
			}
		} else {
			throw new LogicExceptions(linea, LogicExceptions.EXCEPTION_NEED_MATERIALS);
		}
		return true;
	}

	private void showJugadores() throws ExecutionExceptions {
		for (int i = 0; i < jugadores.size(); i++) {
			System.out.println(jugadores.get(i).toString());
			w.escribirLinea("\n\t" + jugadores.get(i).toString());
		}
	}
	
}
