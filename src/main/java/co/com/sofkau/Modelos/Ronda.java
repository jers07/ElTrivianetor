package co.com.sofkau.Modelos;

import java.util.HashMap;

public class Ronda {
    private int idRonda;
    private  String premioConseguir;
    private int numRonda;

    public static HashMap<Integer, Ronda> rondaHashMap = new HashMap<>();

    public Ronda() {
    }

    public Ronda(int idRonda, String premioConseguir, int numRonda) {
        this.idRonda = idRonda;
        this.premioConseguir = premioConseguir;
        this.numRonda = numRonda;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public String getPremioConseguir() {
        return premioConseguir;
    }

    public void setPremioConseguir(String premioConseguir) {
        this.premioConseguir = premioConseguir;
    }

    public int getNumRonda() {
        return numRonda;
    }

    public void setNumRonda(int numRonda) {
        this.numRonda = numRonda;
    }


}
