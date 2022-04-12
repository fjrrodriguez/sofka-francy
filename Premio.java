package solucionJuego;

class Premio {

	public Premio(String nom_premio,int puntaje) {
		id_premio = idSiguiente;
		idSiguiente++;
		this.nom_premio = nom_premio;
		this.puntaje = puntaje;
	}
	
	public String getNombrePremio() {
		return this.nom_premio;
	}
	
	public int getIdPremio() {
		return this.id_premio; 
	}
	public int getPuntajePremio() {
		return this.puntaje;
	}
	
	private int id_premio = 1;
	private static int idSiguiente = 1;
	private String nom_premio;
	private int puntaje;
}
