package solucionJuego;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



class Crear_Partida {
	static Categoria misCategorias;
	static int idPre;
	static int idCat;
	static int contadorCategoria = 1;
	int opcion;

	ConexionBD con = new ConexionBD();
	Connection cn = con.conexion();

	private Jugador miJugador;
	private Scanner entrada = new Scanner(System.in);
	private Premio mispremios;
	private Ronda misRondas;

	public Crear_Partida() {

		// crearJugador();

		do {
			System.out.println();
			System.out.println("MENU DE OPCIONES");
			System.out.println("SELECCIONA LA OPCION DESEADA");
			System.out.println();
			System.out.println("1.MODIFICAR RONDA");
			System.out.println("2.MODIFICAR PREMIO");
			System.out.println("3.CREAR CATEGORIA");
			System.out.println("4.CREAR PREGUNTAS");
			System.out.println("5.JUGAR");
			System.out.println("6.SALIR");
			System.out.println("");
			System.out.print("Escribe la opcion: ");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				// crearRonda(); // crear un limitador para no dejar que ingrese mas de 5 rondas
				break;
			case 2:
				// crearPremio(); // opcion
				break;

			case 3:
				// crearCategoria();
				break;
			case 4:
				// crearPregunta();
				break;
			case 5:
				jugar();
				break;
			default:
				System.out.println("Saliendo del juego...");
				break;
			}

		} while (opcion != 6);

	}

	public void crearJugador() {

		Scanner entrada = new Scanner(System.in);
		String minombre;
		System.out.print("Escribe tu nombre: ");
		minombre = entrada.nextLine();
		// CREAMOS EL JUGADOR Y LO ALAMACENAMOS EN LA BD
		try {
			miJugador = new Jugador(minombre);
			PreparedStatement pps = cn.prepareStatement("INSERT INTO jugador(nom_jugador)VALUES(?)");
			// pps.setString(1,"2");
			pps.setString(1, miJugador.getNomJugador());

			pps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "error de resgistros");
		}
	}

	public void crearRonda() {
		System.out.print("Escribe el numero de la ronda que deseas crear: ");
		int num_ronda = entrada.nextInt();
		misRondas = new Ronda(num_ronda);

		// guardar rondas en la BD
		try {

			PreparedStatement pps = cn.prepareStatement("INSERT INTO ronda(id_ronda)VALUES(?)");

			pps.setInt(1, misRondas.getIdRonda());

			pps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "error de resgistros");
		}
	}

	public void crearPremio() {

		String nombrepremio;
		int puntajepremio;
		entrada.nextLine();
		System.out.print("Escribe el nombre del premio: ");

		nombrepremio = entrada.nextLine();

		System.out.print("Asignale el puntaje al premio: ");
		puntajepremio = entrada.nextInt();

		mispremios = new Premio(nombrepremio, puntajepremio);

		// Agrego la informacion a la BD
		// guardar rondas en la BD

		try {

			PreparedStatement pps = cn.prepareStatement("INSERT INTO premio(nom_premio,puntaje_premio)VALUES(?,?)");

			pps.setString(1, mispremios.getNombrePremio());
			pps.setInt(2, mispremios.getPuntajePremio());

			pps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "error de resgistros");
		}

	}

	public void crearCategoria() {
		String nom_categoria;
		int premio;

		System.out.print("Escribe el nombre de la categoria: ");
		nom_categoria = entrada.nextLine();

		if (nom_categoria.equalsIgnoreCase("FACIL")) {
			idPre = 1;
			idCat = 1;
			misCategorias = new Categoria(nom_categoria, idPre, idCat);// PEDIRLOS POS BD
		} else if (nom_categoria.equalsIgnoreCase("INTERMEDIO")) {
			idPre = 2;
			idCat = 2;
			misCategorias = new Categoria(nom_categoria, idPre, idCat);// PEDIRLOS POS BD
		} else if (nom_categoria.equalsIgnoreCase("MEDIO")) {
			idPre = 3;
			idCat = 3;
			misCategorias = new Categoria(nom_categoria, idPre, idCat);// PEDIRLOS POS BD
		} else if (nom_categoria.equalsIgnoreCase("ALTO")) {
			idPre = 4;
			idCat = 4;
			misCategorias = new Categoria(nom_categoria, idPre, idCat);// PEDIRLOS POS BD
		} else if (nom_categoria.equalsIgnoreCase("DIFICIL")) {
			idPre = 5;
			idCat = 5;
			misCategorias = new Categoria(nom_categoria, idPre, idCat);// PEDIRLOS POS BD

		}

		// AGREGAR CATEGORIA A LA BD

		try {

			PreparedStatement pps = cn
					.prepareStatement("INSERT INTO categoria(nom_categoria,id_premio,id_ronda)VALUES(?,?,?)");

			pps.setString(1, misCategorias.getNombreCategoria());
			pps.setInt(2, idPre);
			pps.setInt(3, idPre);

			pps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "error de resgistros");
		}

	}

	public void crearPregunta() {
		String enunciado;
		String correcta, res2, res3, res4;
		int categoria; // RECOGEN DE LA BD

		entrada.nextLine();
		System.out.print("Escribe el enunciado: ");
		enunciado = entrada.nextLine();

		System.out.print("Escribe la respuesta correcta: ");
		correcta = entrada.nextLine();

		System.out.print("Escribe la segunda respuesta errada: ");
		res2 = entrada.nextLine();

		System.out.print("Escribe la tercera respuesta errada: ");
		res3 = entrada.nextLine();

		System.out.print("Escribe la primera respuesta errada: ");
		res4 = entrada.nextLine();

		System.out.println("Escribe el numero de la categoria que corresponde este enunciado: ");

		System.out.println("1. FACIL");
		System.out.println("2. INTERMEDIO");
		System.out.println("3. MEDIO");
		System.out.println("4. ALTO");
		System.out.println("5. DIFICIL");

		System.out.println();
		System.out.print("Respuesta: ");
		categoria = entrada.nextInt();

		Pregunta misPreguntas = new Pregunta(enunciado, correcta, res2, res3, res4, categoria);

		// Insertar a la BD

		try {

			PreparedStatement pps = cn.prepareStatement(
					"INSERT INTO pregunta(enunciado,correcta,res_2,res_3,res_4,id_categoria)VALUES(?,?,?,?,?,?)");

			pps.setString(1, enunciado);
			pps.setString(2, correcta);
			pps.setString(3, res2);
			pps.setString(4, res3);
			pps.setString(5, res4);
			pps.setInt(6, categoria);

			pps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "error de resgistros");
		}

	}

	public void jugar() {
		
		pregunta1();

	}
	
	public void pregunta1() {
		try {

			String sql = "SELECT enunciado,correcta,res_2,res_3,res_4 FROM pregunta WHERE id_categoria= 1 AND id_pregunta = 3";

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
			
				String enunciado = rs.getString(1);
				String resCorrecta = rs.getString(2);
				String res2 = rs.getString(3);
				String res3 = rs.getString(4);
				String res4 = rs.getString(5);
				
				System.out.println(""); 
				System.out.println(enunciado);
				System.out.println(""); 
				System.out.println(".) "+ resCorrecta);
				System.out.println(".) "+ res2);
				System.out.println(".) "+ res3);
				System.out.println(".) "+ res4);
				System.out.println("");
				// contestar respuesta
				
				System.out.println(enunciado);
			
			}
			
			
		
				
		} catch (SQLException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "error de resgistros");
		}
	
	}
	
}
