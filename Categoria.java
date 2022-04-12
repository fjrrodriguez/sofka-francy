package solucionJuego;

public class Categoria {

	public Categoria(String nom_categoria,int prem_categoria,int ini_ronda) {
		
		id_categoria = idSiguiente;
		idSiguiente++;
		this.nom_categoria = nom_categoria;
		this.prem_categoria = prem_categoria;
		this.ini_ronda = ini_ronda;
	}
	
	public int getIdCategoria() {
		return this.id_categoria;
	}
	public String getNombreCategoria() {
		return this.nom_categoria;
	}
	
	private int id_categoria = 1;
	private static int idSiguiente = 1;
	private String nom_categoria;
	private int prem_categoria;
	private int ini_ronda;
	
}
