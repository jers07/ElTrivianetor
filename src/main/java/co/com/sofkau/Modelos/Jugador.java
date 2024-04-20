package co.com.sofkau.Modelos;

public class Jugador {
    private int idJugador;
    private String nombreJugador;

    public Jugador() {
    }


    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Jugador(int idJugador, String nombreJugador) {
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
}
