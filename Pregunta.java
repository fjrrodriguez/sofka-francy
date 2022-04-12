package solucionJuego;

public class Pregunta {
	public Pregunta(String pregunta,String res_correcta,String respuesta2,String respuesta3,String respuesta4,int cate_pregunta) {
		id_pregunta = idSiguiente;
		idSiguiente++;
		this.pregunta = pregunta;
		this.res_correcta = res_correcta;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.respuesta4 = respuesta4;
		this.cate_pregunta = cate_pregunta;
		
	}
	
	public int getIdPregunta() {
		return this.id_pregunta;
	}
	
	public String getPregunta() {
		return this.pregunta;
	}
	
	public String getResCorrecta() {
		return this.res_correcta;
	}
	
	public String gerRespuesta2() {
		return this.respuesta2;
	}
	
	public String gerRespuesta3() {
		return this.respuesta3;
	}
	
	public String gerRespuesta4() {
		return this.respuesta4;
	}
	
	private int id_pregunta;
	private static int idSiguiente = 1;
	private String pregunta;
	private String res_correcta;
	private String respuesta2,respuesta3,respuesta4;
	private int cate_pregunta;
}
