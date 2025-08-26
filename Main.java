package acceso;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO("usuarios.txt");

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE ACCESO ===");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Cambiar contraseña");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("\n>> Registro de usuario");
                    System.out.println(" REGLAS USUARIO: 6-12 caracteres, sin espacios.");
                    System.out.println(" REGLAS CONTRASEÑA: 6-12 caracteres, al menos 1 mayúscula, 1 símbolo y 3 números.\n");

                    String nuevoUsuario;
                    while (true) {
                        System.out.print("Ingrese usuario: ");
                        nuevoUsuario = sc.nextLine();
                        if (Usuario.validarUsuario(nuevoUsuario)) break;
                        System.out.println("❌ Usuario inválido.");
                    }

                    String nuevaContrasena;
                    while (true) {
                        System.out.print("Ingrese contraseña: ");
                        nuevaContrasena = sc.nextLine();
                        if (Usuario.validarContrasena(nuevaContrasena)) break;
                        System.out.println("❌ Contraseña inválida.");
                    }

                    if (dao.registrarUsuario(new Usuario(nuevoUsuario, nuevaContrasena))) {
                        System.out.println("✅ Usuario registrado.");
                    } else {
                        System.out.println("❌ El usuario ya existe.");
                    }
                    break;

                case 2:
                    System.out.println("\n>> Iniciar sesión");
                    System.out.print("Usuario: ");
                    String user = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String pass = sc.nextLine();

                    if (dao.iniciarSesion(user, pass)) {
                        System.out.println("✅ Bienvenido " + user);
                    } else {
                        System.out.println("❌ Usuario o contraseña incorrectos.");
                    }
                    break;

                case 3:
                    System.out.println("\n>> Cambiar contraseña");
                    System.out.print("Usuario: ");
                    String usu = sc.nextLine();
                    System.out.print("Contraseña actual: ");
                    String oldPass = sc.nextLine();

                    if (dao.iniciarSesion(usu, oldPass)) {
                        String nuevaPass;
                        while (true) {
                            System.out.print("Nueva contraseña: ");
                            nuevaPass = sc.nextLine();
                            if (Usuario.validarContrasena(nuevaPass)) break;
                            System.out.println("❌ Contraseña inválida.");
                        }
                        if (dao.cambiarContrasena(usu, nuevaPass)) {
                            System.out.println("✅ Contraseña actualizada.");
                        }
                    } else {
                        System.out.println("❌ Usuario o contraseña incorrectos.");
                    }
                    break;

                case 4:
                    System.out.println("👋 Saliendo...");
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}