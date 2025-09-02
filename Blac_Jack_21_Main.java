package Arcade.Juegos.Black_Jack_21;

import java.util.Scanner;

public class Blac_Jack_21_Main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String nombre;

        while (true) {
            System.out.print("Ingrese su nombre de usuario (Solo letras): ");
            nombre = sc.nextLine();

            if (nombre.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ]+$")) {
                break;
            } else {
                System.out.println("Nombre inválido. Solo se permiten letras y tildes.");
            }
        }

        Jugador jugador = new Jugador(nombre, 1000);
        
        System.out.println("Hola " + jugador.getNombre_usuario() + ", tienes un saldo inicial de: $" + jugador.getDinero());
        System.out.println("¡Bienvenido a Black Jack 21!");
        cargando.cargando();
        System.out.println("Reglas del juego:");
        System.out.println("1. El objetivo es alcanzar una mano con un valor total lo más cercano posible a 21 sin pasarse.");
        System.out.println("2. Las cartas numéricas (2-10) valen su valor nominal, las figuras (J, Q, K) valen 10 y el As puede valer 1 u 11.");
        System.out.println("3. Si tu mano supera los 21 puntos, pierdes automáticamente la ronda.");
        System.out.println("4. Si tienes un As y una carta de valor 10 (10, J, Q, K) en tu mano inicial, tienes un 'Blackjack' y ganas automáticamente a menos que el crupier también tenga un Blackjack.");
        System.out.println("5. Puedes pedir cartas adicionales ('Hit') para acercarte a 21 o plantarte ('Stand') si estás satisfecho con tu mano actual.");
        System.out.println("6. Si el crupier supera los 21 puntos, todos los jugadores que aún estén en la ronda ganan.");
        System.out.println("7. Si el crupier no se pasa, gana la mano con el valor más alto sin pasarse de 21.");
        System.out.println("8. En caso de empate, el jugador recupera su apuesta.");
        System.out.println("9. Puedes apostar una cantidad de dinero antes de que se repartan las cartas. Si ganas, recibes el doble de tu apuesta. Si pierdes, pierdes tu apuesta.");
        System.out.println("10. El juego continúa hasta que decidas salir o te quedes sin dinero.");
        System.out.println("¡Buena suerte!");
        //Juego juego = new Juego(jugador);
    }
}
