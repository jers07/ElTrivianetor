package co.com.sofkau.Modelos;

public class Jugador {
    private int idJugador;
    private String nombreJugador;
    private String correo;

    public Jugador() {
    }

    public Jugador(int idJugador, String nombreJugador, String correo) {
        this.idJugador = idJugador;
        this.nombreJugador = nombreJugador;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
