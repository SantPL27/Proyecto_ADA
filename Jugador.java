package Arcade.Juegos.Black_Jack_21;

public class Jugador {

    String nombre_usuario;
    int dinero;

    public Jugador(String nombre_usuario, int dinero) {
        this.nombre_usuario = nombre_usuario;
        this.dinero = 1000; 
    }

    public int getDinero() {
        return dinero;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

}
