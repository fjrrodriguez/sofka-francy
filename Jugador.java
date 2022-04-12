package solucionJuego;

class Jugador {
	public Jugador(String nom_jugador) {
		id_jugador = idSiguiente;
		idSiguiente++;
		this.nom_jugador = nom_jugador;
	}
	
	public String getNomJugador() {
		return this.nom_jugador;
	}
	
	private int id_jugador;
	private static int idSiguiente = 1;
	private String nom_jugador;
}
