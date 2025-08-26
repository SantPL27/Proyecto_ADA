package acceso;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    // ===== VALIDACIONES =====
    public static boolean validarUsuario(String usuario) {
        return usuario.length() >= 6 && usuario.length() <= 12 && !usuario.contains(" ");
    }

    public static boolean validarContrasena(String contrasena) {
        if (contrasena.length() < 6 || contrasena.length() > 12) return false;

        boolean mayuscula = false, simbolo = false;
        int numeros = 0;

        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) mayuscula = true;
            else if (!Character.isLetterOrDigit(c)) simbolo = true;
            else if (Character.isDigit(c)) numeros++;
        }
        return mayuscula && simbolo && numeros >= 3;
    }

    // Para guardar en archivo
    @Override
    public String toString() {
        return nombreUsuario + ";" + contrasena;
    }

    // Para reconstruir desde archivo
    public static Usuario fromString(String linea) {
        String[] partes = linea.split(";");
        if (partes.length == 2) {
            return new Usuario(partes[0], partes[1]);
        }
        return null;
    }
}
