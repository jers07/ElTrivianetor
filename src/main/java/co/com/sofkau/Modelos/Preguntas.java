package co.com.sofkau.Modelos;

import java.util.HashMap;

public class Preguntas {
    private int idPregunta ;
    private String nivelDificultad;
    private String categoria;
    private String textoPregunta;
    private int valorPuntos;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcionCorrecta;

    public static HashMap<Integer, String> dificultadMap;

    public Preguntas() {
    }

    public Preguntas(int idPregunta, String nivelDificultad, String categoria, String textoPregunta, int valorPuntos, String opcion1, String opcion2, String opcion3, String opcionCorrecta) {
        this.idPregunta = idPregunta;
        this.nivelDificultad = nivelDificultad;
        this.categoria = categoria;
        this.textoPregunta = textoPregunta;
        this.valorPuntos = valorPuntos;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcionCorrecta = opcionCorrecta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public int getValorPuntos() {
        return valorPuntos;
    }

    public void setValorPuntos(int valorPuntos) {
        this.valorPuntos = valorPuntos;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(String opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public HashMap<Integer, String> getDificultadMap() {
        return dificultadMap;
    }

    public void setDificultadMap(HashMap<Integer, String> dificultadMap) {
        this.dificultadMap = dificultadMap;
    }
}
