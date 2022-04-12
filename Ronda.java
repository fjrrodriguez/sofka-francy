package solucionJuego;

public class Ronda {
	
	public Ronda(int id_ronda) {
		
		//id_ronda = idSiguiente;
		//idSiguiente++;
		this.personaje = personaje;
		this.id_ronda = id_ronda;
	}
	
	public int getIdRonda() {
		return this.id_ronda;
	}
	
	private int id_ronda;
	//private static int idSiguiente = 1;
	private Jugador personaje;
}
