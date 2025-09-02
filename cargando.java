package Arcade.Juegos.Black_Jack_21;

public class cargando {
    
    public static void cargando() {
        try {
            System.out.print("Cargando");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500); // medio segundo
                System.out.print(".");
            }
            System.out.println(); // salto de línea al final
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        }
    }
}