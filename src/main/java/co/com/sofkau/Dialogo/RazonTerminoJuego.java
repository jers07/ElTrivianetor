package co.com.sofkau.Dialogo;

public enum RazonTerminoJuego {
    TIPO_UNO("Jugador Ganador"),TIPO_DOS("Jugador Retirado"),TIPO_TRES("Jugador Perdio");
    private String value;

    private RazonTerminoJuego(String tipo){
        this.value = tipo;
    }

    public String getvalue() {
        return value;
    }
}
