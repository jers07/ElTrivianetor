package co.com.sofkau.Modelos;

public class Historial {
    private int idHistorial;
    private int jugadorIdJugador;
    private String nombreJugador;
    private int puntajeFinal;
    private String RazonTerminoJuego;

    public Historial() {
    }

    public Historial(int jugadorIdJugador, String nombreJugador, int puntajeFinal, String razonTerminoJuego) {
        this.jugadorIdJugador = jugadorIdJugador;
        this.nombreJugador = nombreJugador;
        this.puntajeFinal = puntajeFinal;
        RazonTerminoJuego = razonTerminoJuego;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getJugadorIdJugador() {
        return jugadorIdJugador;
    }

    public void setJugadorIdJugador(int jugadorIdJugador) {
        this.jugadorIdJugador = jugadorIdJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(int puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    public String getRazonTerminoJuego() {
        return RazonTerminoJuego;
    }

    public void setRazonTerminoJuego(String razonTerminoJuego) {
        RazonTerminoJuego = razonTerminoJuego;
    }
}
